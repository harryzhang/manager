package com.smartpay.ops.single.dto.impl.query.request;

import com.smartpay.ops.common.dto.impl.Sign;
import com.smartpay.ops.single.SingleAgentpayService;
import com.smartpay.ops.single.SinglepayResolveException;
import com.smartpay.ops.single.dto.ISingle;

public class QueryRequest implements ISingle{
	private QueryRequestEnvelope envelope;

	private Sign sign = new Sign();

	public QueryRequestEnvelope getEnvelope() {
		return envelope;
	}

	public void setEnvelope(QueryRequestEnvelope envelope) {
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
