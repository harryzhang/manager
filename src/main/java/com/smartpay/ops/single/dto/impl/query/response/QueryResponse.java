package com.smartpay.ops.single.dto.impl.query.response;

import com.smartpay.ops.common.dto.impl.Sign;
import com.smartpay.ops.single.SingleAgentpayService;
import com.smartpay.ops.single.SinglepayResolveException;
import com.smartpay.ops.single.dto.ISingle;

public class QueryResponse implements ISingle {
	private QueryResponseEnvelope envelope;

	private Sign sign = new Sign();

	public QueryResponseEnvelope getEnvelope() {
		return envelope;
	}

	public void setEnvelope(QueryResponseEnvelope envelope) {
		this.envelope = envelope;
	}

	public Sign getSign() {
		return sign;
	}

	public void setSign(Sign sign) {
		this.sign = sign;
	}
	public String toXML() throws SinglepayResolveException{
		return SingleAgentpayService.resolverAdapter.doRenderResponse(this,this.getEnvelope().getHead().getVersion());
	}
}
