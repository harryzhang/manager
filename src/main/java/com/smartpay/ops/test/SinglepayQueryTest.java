package com.smartpay.ops.test;

import com.smartpay.ops.common.dto.impl.Head;
import com.smartpay.ops.common.dto.impl.Sign;
import com.smartpay.ops.single.Env;
import com.smartpay.ops.single.PaymentVersionNo;
import com.smartpay.ops.single.SingleAgentpayService;
import com.smartpay.ops.single.SinglepayResolveException;
import com.smartpay.ops.single.dto.impl.query.request.QueryRequest;
import com.smartpay.ops.single.dto.impl.query.request.QueryRequestBody;
import com.smartpay.ops.single.dto.impl.query.request.QueryRequestEnvelope;
import com.smartpay.ops.single.dto.impl.query.response.QueryResponse;
import com.smartpay.ops.single.dto.impl.response.Response;
import com.smartpay.ops.util.SeqUtil;


public class SinglepayQueryTest {	
	public static void main(String args[]){
		QueryRequest queryRequest = new QueryRequest();
		QueryRequestEnvelope envelope = new QueryRequestEnvelope();		
		//String serverUrl="http://192.168.88.175:8080/gateway/singleQuery";
		String serverUrl="http://localhost:8080/gateway/singleQuery";
		//String serverUrl="http://opsweb.koolyun.cn/gateway/singleagentpay";
		Env env = new Env();
		env.setDebug(true);
		env.setServerUrl(serverUrl);//提交路径
		env.setSmartpayCertificatePath("/opsapp/config/ops-test.cer");//支付通证书
		env.setMerchantPrivateCertificatePath("/opsapp/config/test-rsa.pfx");//商户私钥
//		env.setMerchantPublicCertificatePath("F:\\wrk\\ops\\ops-batch-api\\src\\test\\java\\\\public-rsa.cer");//商户公钥
		env.setMerchantPrivateCertificatePassword("123456");// 商户私钥密码

		//报文头  开始
		Head head = new Head();
		head.setCharset("UTF-8");//报文编码
		head.setVersion(PaymentVersionNo.V1077);//报文件版本
		envelope.setHead(head);
		//报文头  结束

		//报文内容
		QueryRequestBody body = new QueryRequestBody();
		String mchtId="100020091219001";
//		String mchtOrderNo=SeqUtil.getTradeNo();
		
		body.setMchtId(mchtId);
		body.setMchtOrderNo("E20160715092615");
		body.setPaymentBusinessType("SINGLE_PAY");
		
		envelope.setBody(body);
		queryRequest.setEnvelope(envelope);

		Sign sign = new Sign();
		sign.setSignType(queryRequest.getSign().getSignType());
		queryRequest.setSign(sign);

		try {
			 System.out.println("payRequest : " +queryRequest.toXML());
			 Response queryResponse= (Response) SingleAgentpayService.request(queryRequest, env);
			 System.out.println("queryResponse : "  + queryResponse.toXML());
		} catch (SinglepayResolveException e) {
			e.printStackTrace();
		}
	}
}
