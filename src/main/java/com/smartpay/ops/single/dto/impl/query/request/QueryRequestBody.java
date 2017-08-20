package com.smartpay.ops.single.dto.impl.query.request;

import com.smartpay.ops.single.dto.IBody;

public class QueryRequestBody implements IBody{
	private String mchtId;
	private String mchtOrderNo;
	private String mchtBatchNo;
	private String paymentBusinessType;
	@Override
	public String getMchtId() {
		return mchtId;
	}
	@Override
	public String getMchtOrderNo() {
		return mchtOrderNo;
	}

	public void setMchtId(String mchtId) {
		this.mchtId = mchtId;
	}

	public void setMchtOrderNo(String mchtOrderNo) {
		this.mchtOrderNo = mchtOrderNo;
	}
	public String getMchtBatchNo() {
		return mchtBatchNo;
	}
	public void setMchtBatchNo(String mchtBatchNo) {
		this.mchtBatchNo = mchtBatchNo;
	}
	public String getPaymentBusinessType() {
		return paymentBusinessType;
	}
	public void setPaymentBusinessType(String paymentBusinessType) {
		this.paymentBusinessType = paymentBusinessType;
	}
	
	
	
}
