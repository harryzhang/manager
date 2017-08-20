package com.smartpay.ops.pay;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.jeecgframework.core.util.ResourceUtil;

import com.smartpay.ops.client.RequestOrder;
import com.smartpay.ops.client.web.MerchantClient;
import com.smartpay.ops.common.dto.impl.Head;
import com.smartpay.ops.common.dto.impl.Sign;
import com.smartpay.ops.single.Env;
import com.smartpay.ops.single.SingleAgentpayService;
import com.smartpay.ops.single.SinglepayResolveException;
import com.smartpay.ops.single.dto.impl.request.Request;
import com.smartpay.ops.single.dto.impl.request.RequestEnvelope;
import com.smartpay.ops.single.dto.impl.request.agentPay.SingleAgentpayRequestBody;
import com.smartpay.ops.single.dto.impl.response.Response;
import com.smartpay.ops.single.dto.impl.response.agentPay.SingleAgentpayResponseBody;
import com.smartpay.ops.util.SeqUtil;
import com.smartpay.ops.util.XmlUtils;

public class Singlepay {

	// 服务器地址
	private static String SERVERURL = "https://pg.openepay.com/gateway/singleagentpay";
	// 支付通证书
	private static String CERTIFICATEPATH = ResourceUtil.getConfigByName("CERTIFICATEPATH");
	// 商户私钥
	private static String PRIVATECERTIFICATEPATH = ResourceUtil.getConfigByName("PRIVATECERTIFICATEPATH");
	// 商户公钥
	private static String PUBLICCERTIFICATEPATH = ResourceUtil.getConfigByName("PUBLICCERTIFICATEPATH");
	// 密码
	//private static String PASSWORD = "zxcvbnm1";
	private static String PASSWORD = "123098";
	// 商户信息
	//private static String MACHID = "103610161205001";
	private static String MACHID = "107004161116003";
	
	// 通知地址
	private static String NOTIFYURL = ResourceUtil.getConfigByName("PUBLICCERTIFICATEPATH");

	public static Env getEnv() {
		// String serverUrl="http://localhost:8080/gateway/singleagentpay";
		// String
		// serverUrltest="http://opsweb.koolyun.cn/gateway/singleagentpay";

		Env env = new Env();
		env.setDebug(true);
		env.setServerUrl(SERVERURL);// 提交路径
		env.setSmartpayCertificatePath(CERTIFICATEPATH);// 支付通证书
		env.setMerchantPrivateCertificatePath(PRIVATECERTIFICATEPATH);// 商户私钥
		env.setMerchantPublicCertificatePath(PUBLICCERTIFICATEPATH);// 商户公钥
		env.setMerchantPrivateCertificatePassword(PASSWORD);// 商户私钥密码
		return env;
	}

	public static Request getRequest(String accountNo, String accountName, String amt, String bankName, String bankNo) {
		Request agentpayRequest = new Request();
		RequestEnvelope envelope = new RequestEnvelope();
		// 报文头 开始
		Head head = new Head();
		head.setCharset("UTF-8");// 报文编码
		head.setVersion("v1.0.7.6");// 报文件版本
		envelope.setHead(head);
		// 报文头 结束
		// 报文内容
		SingleAgentpayRequestBody body = new SingleAgentpayRequestBody();
		String mchtId = MACHID;
		String mchtOrderNo = SeqUtil.getTradeNo();
		String dateTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		body.setMchtId(mchtId);
		body.setMchtOrderNo(mchtOrderNo);
		body.setOrderDateTime(dateTime);
		body.setAccountNo(accountNo);
		// body.setAccountNo("6208888888888808");
		// body.setAccountName("单代付");
		body.setAccountName(accountName);
		body.setAccountType("PERSONAL");
		// body.setAmt("10");//金额：整数，精确到分。例如，票款为1280元，则表示为"128000"
		// body.setBankName("虚拟银行");//收款方开户行名称
		if (null == bankNo || "".equals(bankNo)) {
			bankNo = "105345400071";
		}
		body.setBankNo(bankNo);// 收款方开户行行号
		body.setAmt(amt);// 金额：整数，精确到分。例如，票款为1280元，则表示为"128000"
		body.setBankName(bankName);// 收款方开户行名称
		// body.setBankNo(bankNo);//收款方开户行行号
		body.setRemark("备注");
		body.setNotifyUrl(NOTIFYURL);
		envelope.setBody(body);
		agentpayRequest.setEnvelope(envelope);

		Sign sign = new Sign();
		sign.setSignType(agentpayRequest.getSign().getSignType());
		agentpayRequest.setSign(sign);
		return agentpayRequest;
	}

	public static String pay(String accountNo, String accountName, String amt, String bankName, String bankNo) {
		Env env = getEnv();
		try {
			Request agentpayRequest = getRequest(accountNo, accountName, amt, bankName, bankNo);
			Response payResponse = (Response) SingleAgentpayService.request(agentpayRequest, env);
			SingleAgentpayResponseBody sar = (SingleAgentpayResponseBody) payResponse.getEnvelope().getBody();
			if ("E0000".equals(sar.getResponseCode())) {
				return "支付成功=" + sar.getMchtOrderNo();
			} else {
				return sar.getResponseMsg();
			}
		} catch (SinglepayResolveException e) {
			e.printStackTrace();
		}

		return "付款错误,请联系管理员";
	}


	public static void main(String args[]) {

		// 用户银行卡号
		//String accountNo = "6217003890005887448";
		//String accountName = "李勇";
		//String accountNo = "6217997300040017371";
		String accountNo = "6226096556212788";
		String accountName = "曹乘嘉";
		// 金额 分为单
		String amt = "135000";
		// 银行名称
		//String bankName = "中国建设银行胜风支行";
		//String bankNo = "105345400071";
		String bankName = "中国招商银行";
		String bankNo = null;
		String message = pay(accountNo, accountName, amt, bankName, bankNo);
		System.out.println(message);

	}

}
