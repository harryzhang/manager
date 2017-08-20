package com.smartpay.ops.common.dto.impl;

import com.smartpay.ops.common.dto.IHead;

public class Head implements IHead {

	/**
	 * 版本号
	 */
	private String version;

	/**
	 * 字符集
	 */
	private String charset = "UTF-8";

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the charset
	 */
	public String getCharset() {
		return charset;
	}

	/**
	 * @param charset
	 *            the charset to set
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}

}
