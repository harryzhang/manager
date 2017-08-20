package com.smartpay.ops.single.dto;

import com.smartpay.ops.common.dto.IHead;

public interface IEnvelope {

	IHead getHead();

	IBody getBody();

}
