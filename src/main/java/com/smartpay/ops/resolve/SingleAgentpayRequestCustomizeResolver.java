package com.smartpay.ops.resolve;

import com.smartpay.ops.common.dto.impl.Head;
import com.smartpay.ops.common.dto.impl.Sign;
import com.smartpay.ops.single.PaymentVersionNo;
import com.smartpay.ops.single.SinglepayResolveException;
import com.smartpay.ops.single.dto.IBody;
import com.smartpay.ops.single.dto.impl.request.Request;
import com.smartpay.ops.single.dto.impl.request.RequestEnvelope;
import com.smartpay.ops.single.dto.impl.request.agentPay.SingleAgentpayRequestBody;
import com.thoughtworks.xstream.XStream;

public class SingleAgentpayRequestCustomizeResolver implements ICustomizeResolver {
	public void doCustomizeResolve(XStream xStream) throws SinglepayResolveException {
		xStream.alias("request", Request.class);
		xStream.alias("envelope", RequestEnvelope.class);
		xStream.alias("head", Head.class);
		xStream.alias("body", IBody.class,SingleAgentpayRequestBody.class);
		xStream.alias("sign", Sign.class);

	}

	public String[] getSupportedVersionNoAndDirection() {
		return new String[] { PaymentVersionNo.V1076 + ResolverAdapter.DIRECTION_REQUEST };
	}
}
