package com.smartpay.ops.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成流水号
 * 
 */
public class SeqUtil {

	private static int sequence = 0;
	private static int sequence2 = 0;

	static String path = "";

	/**
	 * 订单号
	 * 
	 * @return
	 */
	public static synchronized String getTradeNo() {
		sequence2 = sequence2 >= 999999 ? 1 : sequence2 + 1;
		String s = Integer.toString(sequence2);
		String datetime = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
		return "D"+datetime+addLeftZero(s, 6);
	}
	/**
	 * YYMMDDHHMMSS+6位自增长码(18位)
	 * 
	 * @return
	 */
	public static synchronized String getLocalSeqNum() {
		sequence = sequence >= 999999 ? 1 : sequence + 1;
		String datetime = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
		String s = Integer.toString(sequence);
		return datetime + addLeftZero(s, 6);
	}
	
	/**
	 * 左填0
	 * 
	 * @param s
	 * @param length
	 * @return
	 */
	public static String addLeftZero(String s, int length) {
		int old = s.length();
		if (length > old) {
			char[] c = new char[length];
			char[] x = s.toCharArray();
			if (x.length > length) {
				throw new IllegalArgumentException("Numeric value is larger than intended length: " + s + " LEN " + length);
			}
			int lim = c.length - x.length;
			for (int i = 0; i < lim; i++) {
				c[i] = '0';
			}
			System.arraycopy(x, 0, c, lim, x.length);
			return new String(c);
		}
		return s.substring(0, length);

	}
	public static void main(String[] args) {
		System.out.println(SeqUtil.getLocalSeqNum());
	}

}
