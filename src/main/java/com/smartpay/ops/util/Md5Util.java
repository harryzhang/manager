/**
 * Created at 2008-06-18.
 * 提供计算md5的常用方法.
 */
package com.smartpay.ops.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author pony
 * 
 *         如果有任何对代码的修改,请按下面的格式注明修改的内容. 序号 时间 作者 修改内容 1. 2008-6-18 pony created
 *         this class.
 */
public class Md5Util {

	private Md5Util() {
	}

	/**
	 * Returns a MessageDigest for the given <code>algorithm</code>.
	 * 
	 * @param algorithm
	 *            The MessageDigest algorithm name.
	 * @return An MD5 digest instance.
	 * @throws RuntimeException
	 *             when a {@link java.security.NoSuchAlgorithmException} is
	 *             caught
	 */

	static MessageDigest getDigest() {
		try {
			return MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Calculates the MD5 digest and returns the value as a 16 element
	 * <code>byte[]</code>.
	 * 
	 * @param data
	 *            Data to digest
	 * @return MD5 digest
	 */
	public static byte[] md5(byte[] data) {
		return getDigest().digest(data);
	}

}
