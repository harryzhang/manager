package com.smartpay.ops.single.dto.impl.response;

import com.smartpay.ops.common.dto.impl.Head;
import com.smartpay.ops.single.dto.IBody;
import com.smartpay.ops.single.dto.IEnvelope;

public class ResponseEnvelope implements IEnvelope {
	private Head head = new Head();

	private IBody body;

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public IBody getBody() {
		return body;
	}

	public void setBody(IBody body) {
		this.body = body;
	}
}
