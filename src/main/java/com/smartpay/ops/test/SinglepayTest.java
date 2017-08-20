package com.smartpay.ops.test;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.smartpay.ops.common.dto.impl.Head;
import com.smartpay.ops.common.dto.impl.Sign;
import com.smartpay.ops.single.Env;
import com.smartpay.ops.single.SingleAgentpayService;
import com.smartpay.ops.single.SinglepayResolveException;
import com.smartpay.ops.single.dto.impl.request.Request;
import com.smartpay.ops.single.dto.impl.request.RequestEnvelope;
import com.smartpay.ops.single.dto.impl.request.agentPay.SingleAgentpayRequestBody;
import com.smartpay.ops.single.dto.impl.response.Response;
import com.smartpay.ops.util.SeqUtil;

public class SinglepayTest {
	public static Env getEnv(){
		//String serverUrl="http://localhost:8080/gateway/singleagentpay";
//		String serverUrltest="http://opsweb.koolyun.cn/gateway/singleagentpay";
		String serverUrl="https://pg.openepay.com/gateway/singleagentpay";
		Env env = new Env();
		env.setDebug(true);
		env.setServerUrl(serverUrl);//提交路径
		env.setSmartpayCertificatePath("D:/kaipay/lvc/ops-prod.cer");//支付通证书
		env.setMerchantPrivateCertificatePath("D:/kaipay/lvc/lvc-rsa.pfx");//商户私钥
		env.setMerchantPublicCertificatePath("D:/kaipay/lvc/public-rsa.cer");//商户公钥
		env.setMerchantPrivateCertificatePassword("zxcvbnm1");// 商户私钥密码
		return env;
	}
	
	public static Request getRequest(){
		Request agentpayRequest = new Request();
		RequestEnvelope envelope = new RequestEnvelope();		
		//报文头  开始
		Head head = new Head();
		head.setCharset("UTF-8");//报文编码
		head.setVersion("v1.0.7.6");//报文件版本
		envelope.setHead(head);
		//报文头  结束

		//报文内容
		SingleAgentpayRequestBody body = new SingleAgentpayRequestBody();
		String mchtId="107004161116003";
		String mchtOrderNo=SeqUtil.getTradeNo();
		String dateTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		body.setMchtId(mchtId);
		body.setMchtOrderNo(mchtOrderNo);
		body.setOrderDateTime(dateTime);
		body.setAccountNo("6208888888888808");
		body.setAccountName("单代付");
		body.setAccountType("PERSONAL");
		body.setAmt("10");//金额：整数，精确到分。例如，票款为1280元，则表示为"128000" 
		body.setBankName("虚拟银行");//收款方开户行名称
		body.setBankNo("677843000099");//收款方开户行行号 
		body.setRemark("备注");
		body.setNotifyUrl("http://opsweb.koolyun.cn:8082/demo/mcht/receive.jsp");
		envelope.setBody(body);
		agentpayRequest.setEnvelope(envelope);

		Sign sign = new Sign();
		sign.setSignType(agentpayRequest.getSign().getSignType());
		agentpayRequest.setSign(sign);
		return agentpayRequest;
	}
	public static void pay(){
		Env env = getEnv();
		try {
			Request agentpayRequest =getRequest();
			System.out.println("payRequest : " +agentpayRequest.toXML());
			Response payResponse= (Response) SingleAgentpayService.request(agentpayRequest, env);
			System.out.println("payResponse : "  +payResponse.toXML());
		} catch (SinglepayResolveException e) {
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		pay();
		
	}

}
