package com.smartpay.ops.resolve;

import com.smartpay.ops.single.SinglepayResolveException;
import com.thoughtworks.xstream.XStream;

/**
 * 自定义报文解析器扩展
 * 
 * @author Angi
 * 
 */
public interface ICustomizeResolver {

	void doCustomizeResolve(XStream xStream) throws SinglepayResolveException;

	String[] getSupportedVersionNoAndDirection();
}
