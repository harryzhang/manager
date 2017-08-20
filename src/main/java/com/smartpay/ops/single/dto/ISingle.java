package com.smartpay.ops.single.dto;

import com.smartpay.ops.common.dto.IMessage;
import com.smartpay.ops.common.dto.ISign;

public interface ISingle extends IMessage{

	public static String ENCODING = "UTF-8";
	
	IEnvelope getEnvelope();

	ISign getSign();

}
