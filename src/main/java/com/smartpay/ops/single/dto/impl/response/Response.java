package com.smartpay.ops.single.dto.impl.response;

import com.smartpay.ops.common.dto.impl.Sign;
import com.smartpay.ops.single.SingleAgentpayService;
import com.smartpay.ops.single.SinglepayResolveException;
import com.smartpay.ops.single.dto.ISingle;

public class Response  implements ISingle {
	private ResponseEnvelope envelope;

	private Sign sign = new Sign();

	public Sign getSign() {
		return sign;
	}

	public void setSign(Sign sign) {
		this.sign = sign;
	}

	public ResponseEnvelope getEnvelope() {
		return envelope;
	}

	public void setEnvelope(ResponseEnvelope envelope) {
		this.envelope = envelope;
	}
	
	public String toXML() throws SinglepayResolveException{
		return SingleAgentpayService.resolverAdapter.doRenderResponse(this,this.getEnvelope().getHead().getVersion());
	}
}
