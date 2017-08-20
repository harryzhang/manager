package com.smartpay.ops.resolve;

import com.smartpay.ops.common.dto.impl.Head;
import com.smartpay.ops.common.dto.impl.Sign;
import com.smartpay.ops.single.PaymentVersionNo;
import com.smartpay.ops.single.SinglepayResolveException;
import com.smartpay.ops.single.dto.IBody;
import com.smartpay.ops.single.dto.impl.query.request.QueryRequest;
import com.smartpay.ops.single.dto.impl.query.request.QueryRequestBody;
import com.smartpay.ops.single.dto.impl.query.request.QueryRequestEnvelope;
import com.thoughtworks.xstream.XStream;

public class SingleAgentpayQueryRequestCustomizeResolver implements ICustomizeResolver {
	public void doCustomizeResolve(XStream xStream) throws SinglepayResolveException {
		xStream.alias("request", QueryRequest.class);
		xStream.alias("envelope", QueryRequestEnvelope.class);
		xStream.alias("head", Head.class);
		xStream.alias("body", IBody.class, QueryRequestBody.class);
		xStream.alias("sign", Sign.class);

	}

	public String[] getSupportedVersionNoAndDirection() {
		return new String[] { PaymentVersionNo.V1077 + ResolverAdapter.DIRECTION_REQUEST };
	}
}
