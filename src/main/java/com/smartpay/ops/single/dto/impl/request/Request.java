package com.smartpay.ops.single.dto.impl.request;

import com.smartpay.ops.common.dto.impl.Sign;
import com.smartpay.ops.single.SingleAgentpayService;
import com.smartpay.ops.single.SinglepayResolveException;
import com.smartpay.ops.single.dto.ISingle;

public class Request implements ISingle {
	private RequestEnvelope envelope;

	private Sign sign = new Sign();

	public RequestEnvelope getEnvelope() {
		return envelope;
	}

	public void setEnvelope(RequestEnvelope envelope) {
		this.envelope = envelope;
	}

	public Sign getSign() {
		return sign;
	}

	public void setSign(Sign sign) {
		this.sign = sign;
	}
	public String toXML() throws SinglepayResolveException{
		return SingleAgentpayService.resolverAdapter.doRenderRequest(this,this.getEnvelope().getHead().getVersion());
	}
}
