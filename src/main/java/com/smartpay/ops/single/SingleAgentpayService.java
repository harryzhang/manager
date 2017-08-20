package com.smartpay.ops.single;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.protocol.Protocol;

import com.smartpay.ops.resolve.ICustomizeResolver;
import com.smartpay.ops.resolve.ResolverAdapter;
import com.smartpay.ops.resolve.SingleAgentpayQueryRequestCustomizeResolver;
import com.smartpay.ops.resolve.SingleAgentpayQueryResponseCustomizeResolver;
import com.smartpay.ops.resolve.SingleAgentpayRequestCustomizeResolver;
import com.smartpay.ops.resolve.SingleAgentpayResponseCustomizeResolver;
import com.smartpay.ops.single.dto.ISingle;
import com.smartpay.ops.util.Base64Utils;
import com.smartpay.ops.util.Md5Util;
import com.smartpay.ops.util.MySSLProtocolSocketFactory;
import com.smartpay.ops.util.Rsa;


public class SingleAgentpayService {
	public static ResolverAdapter resolverAdapter = new ResolverAdapter();

	static {
		// 初始化对象渲染器
		List<ICustomizeResolver> customizeResolvers = new ArrayList<ICustomizeResolver>();

		SingleAgentpayRequestCustomizeResolver agentpayRequestCustomizeResolver = new SingleAgentpayRequestCustomizeResolver();
		SingleAgentpayResponseCustomizeResolver agentpayResponseCustomizeResolver = new SingleAgentpayResponseCustomizeResolver();
		SingleAgentpayQueryRequestCustomizeResolver singleAgentpayQueryRequestCustomizeResolver=new SingleAgentpayQueryRequestCustomizeResolver();
		SingleAgentpayQueryResponseCustomizeResolver singleAgentpayQueryResponseCustomizeResolver=new SingleAgentpayQueryResponseCustomizeResolver();
		customizeResolvers.add(agentpayRequestCustomizeResolver);
		customizeResolvers.add(agentpayResponseCustomizeResolver);
		customizeResolvers.add(singleAgentpayQueryRequestCustomizeResolver);
		customizeResolvers.add(singleAgentpayQueryResponseCustomizeResolver);
		resolverAdapter.addCustomizeResolvers(customizeResolvers);

	}

	/**
	 * 请求
	 * 
	 * @param batch
	 * @param env
	 * @return
	 * @throws SinglepayResolveException
	 */
	public static ISingle request(ISingle single, Env env) throws SinglepayResolveException {
		if(env.isDebug()){
			System.out.println("1. Env："+  env.toString());
		}
		
		String version = single.getEnvelope().getHead().getVersion();
		// 设置商户证书
		single.getSign().setCertificate("");
		if(!Env.ENCODE.equals(single.getEnvelope().getHead().getCharset())){
			throw new SinglepayResolveException("不支持的字符集"+single.getEnvelope().getHead().getCharset());
		}
		try {
			String requestEnvelope = resolverAdapter.doRenderRequest(single.getEnvelope(),version);
			if(env.isDebug()){
				System.out.println("2. requestEnvelope ："+  requestEnvelope);
			}
			byte[] md5hash = Md5Util.md5(requestEnvelope.getBytes(Env.ENCODE));
			PrivateKey  privateKey =  Rsa.loadPrivateKey(env.getMerchantPrivateCertificatePath(), env.getMerchantPrivateCertificatePassword());
			String signMsg = Base64Utils.encode(Rsa.signSha1WithRsa(md5hash, privateKey));
			if(env.isDebug()){
				System.out.println("3. signMsg ："+  signMsg);
			}
			single.getSign().setSignContent(signMsg);
		} catch (UnsupportedEncodingException e) {
			throw new SinglepayResolveException("不支持的字符集", e);
		}catch (Exception e) {
			throw new SinglepayResolveException("签名失败", e);
		}
		String requestXml = resolverAdapter.doRenderRequest(single,version);
		//String requestXml = "<request><envelope><head><version>v1.0.7.6</version><charset>UTF-8</charset></head><body><mchtId>100020091219001</mchtId><mchtOrderNo>E20160630101104</mchtOrderNo><accountNo>88881234567</accountNo><accountName>张三</accountName><accountType>PERSONAL</accountType><bankNo>111111111111</bankNo><bankName>虚拟银行</bankName><amt>100</amt><remark></remark><notifyUrl>http://</notifyUrl><orderDateTime>20160630101104</orderDateTime></body></envelope><sign><signType>1</signType><certificate></certificate><signContent>NoKF4wYfrMurl7UDzoajnQ7DPQzEIuL52jtxOa5b6fVHvZ5Xg7xF2wRGSwEtj+G10C5acwH6DviuOL/fIVMq8LnWdk0HlIraXnWQRHUSygw+0jUijcLWRsrFSoapLYf+h7Si/zJcJ14lyrHHKmACqXlO2lOLV8uI4SV9kwMs9f0=</signContent></sign></request>";
		if(env.isDebug()){
			System.out.println("4. requestXml ："+  requestXml);
		}
		String requestXmlBase64;
		try {
			byte[] data = requestXml.getBytes(Env.ENCODE);
			// base64 encode
			requestXmlBase64 = Base64Utils.encode(data);
			if(env.isDebug()){
				System.out.println("5. requestXml after base64 ："+  requestXmlBase64);
			}
		} catch (Exception e) {
			throw new SinglepayResolveException("编码报文失败", e);
		}
		// 发送
		String response;
		String responseXmlBase64 ;
		try {
			responseXmlBase64 = send(env.getServerUrl(),requestXmlBase64,Env.ENCODE);
			if(env.isDebug()){
				System.out.println("6. response   ："+  responseXmlBase64);
			}
			// Base64 decode
			byte[] data = Base64Utils.decode(responseXmlBase64);
			response = new String(data,Env.ENCODE);
			if(env.isDebug()){
				System.out.println("7. response (plain text)："+  response);
			}
		} catch (Exception e) {
			System.err.println("实时代付异常："+e.getMessage());
			throw new SinglepayResolveException("解码失败", e);
		}

		ISingle responseBatch = (ISingle)resolverAdapter.doParseResponse(response,version);
		// HexDecode，然后验证签名
		try {
			String envelope = resolverAdapter.doRenderResponse(responseBatch.getEnvelope(),version);
			//String charset  = responseBatch.getEnvelope().getHead().getCharset();
			String signContent = responseBatch.getSign().getSignContent();
			PublicKey  PublicKey  = Rsa.loadPublicKey(env.getSmartpayCertificatePath());
			byte[] md5hash = Md5Util.md5(envelope.getBytes(Env.ENCODE));
			boolean result = Rsa.verfySha1WithRsa(Base64Utils.decode(signContent), md5hash, PublicKey);
			System.out.println("验签["+version+"]："+ result);
			if (!result) {
				throw new SinglepayResolveException("验签失败");
			}
		} catch (UnsupportedEncodingException e) {
			throw new SinglepayResolveException("不支持的字符集", e);
		}catch (SinglepayResolveException e) {
			throw e;
		}catch (Exception e) {
			throw new SinglepayResolveException("验签失败", e);
		}
//		vars.remove();
		return responseBatch;

	}

	/**
	 * 发送请求，取得响应
	 * 
	 * @param reqXmlMsg
	 * @param env
	 * @return
	 * @throws SinglepayResolveException
	 */
	public static String send(String serverUrl, String params,String encoding) throws Exception {
		String strResponse=null;
		HttpClient httpclient=null;
		ReadableByteChannel readChannel = null;
		try{
			httpclient = new HttpClient();
			
			PostMethod postmethod = new PostMethod(serverUrl);
			NameValuePair[] data = { new NameValuePair("reqMsg",params)};
			postmethod.setRequestBody(data);
			int responseCode=httpclient.executeMethod(postmethod);		
			if(serverUrl.startsWith("https")){			
				Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);   
				Protocol.registerProtocol("https", myhttps);    
	
			}
			if(responseCode==HttpURLConnection.HTTP_OK){
				readChannel = Channels.newChannel(postmethod.getResponseBodyAsStream());
				ByteBuffer buffer = ByteBuffer.allocate(2000);
				readChannel.read(buffer);
				strResponse = new String(buffer.array(), encoding);
			}else{
				if(null==strResponse||"".equals(strResponse)){
					throw new SinglepayResolveException(serverUrl+"服务器响应为空");
				}
			}
		}catch(Exception e){
			throw new SinglepayResolveException(serverUrl+"服务器响应为空");
		}finally{
			readChannel.close();
		}
		
		return strResponse;
	}
}
