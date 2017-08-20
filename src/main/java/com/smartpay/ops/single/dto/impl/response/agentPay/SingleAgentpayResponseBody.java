package com.smartpay.ops.single.dto.impl.response.agentPay;

import com.smartpay.ops.single.dto.impl.request.agentPay.SingleAgentpayRequestBody;


public class SingleAgentpayResponseBody extends SingleAgentpayRequestBody{
	/**
	 * 响应 码
	 */
	private String responseCode;

	/**
	 * 响应信息
	 */
	private String responseMsg;
	/**
	 * 代付交易状态
	 */
	private String status;
	
	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
