package com.smartpay.ops.resolve;

import com.smartpay.ops.common.dto.impl.Head;
import com.smartpay.ops.common.dto.impl.Sign;
import com.smartpay.ops.single.PaymentVersionNo;
import com.smartpay.ops.single.SinglepayResolveException;
import com.smartpay.ops.single.dto.IBody;
import com.smartpay.ops.single.dto.impl.query.response.SingleAgentpayQueryResponseBody;
import com.smartpay.ops.single.dto.impl.response.Response;
import com.smartpay.ops.single.dto.impl.response.ResponseEnvelope;
import com.thoughtworks.xstream.XStream;

public class SingleAgentpayQueryResponseCustomizeResolver implements ICustomizeResolver {

	public void doCustomizeResolve(XStream xStream) throws SinglepayResolveException {
		xStream.alias("response", Response.class);
		xStream.alias("envelope", ResponseEnvelope.class);
		xStream.alias("head", Head.class);
		xStream.alias("body",IBody.class, SingleAgentpayQueryResponseBody.class);
		xStream.alias("sign", Sign.class);
	}

	public String[] getSupportedVersionNoAndDirection() {
		return new String[] { PaymentVersionNo.V1077 + ResolverAdapter.DIRECTION_RESPONSE };
	}
}
