package com.smartpay.ops.common.dto;

public interface ISign {

	String getSignType();

	String getCertificate();

	String getSignContent();

	void setSignContent(String signContent);

	void setCertificate(String certificate);

}