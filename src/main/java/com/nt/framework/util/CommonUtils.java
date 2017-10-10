package com.nt.framework.util;

import java.util.Random;
import java.util.UUID;

/**
 * 
 * @ClassName: CommonUtils
 * @Description: 一些公共的工具类
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月15日 上午10:38:58
 */
public class CommonUtils {

	public static final String SMS_SN_PREFIX = "WSSMS";// 短信流水号前缀
	public static final long SMS_SN_FIRST = 1000L;// 短信流水号起始数
	public static final long SMS_SN_STEP = 1L;// 短信流水号步长

	/**
	 * 随机获取UUID字符串(无中划线)
	 * 
	 * @return UUID字符串
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18) + uuid.substring(19, 23) + uuid.substring(24);
	}

	/**
	 * 随机获取字符串
	 * 
	 * @param length
	 *            随机字符串长度
	 * 
	 * @return 随机字符串
	 */
	public static String getRandomString(int length) {
		if (length <= 0) {
			return "";
		}
		char[] randomChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm' };
		Random random = new Random();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			stringBuffer.append(randomChar[Math.abs(random.nextInt()) % randomChar.length]);
		}
		return stringBuffer.toString();
	}

	/**
	 * 随机获取数字串
	 * 
	 * @param length
	 *            随机数字串
	 * 
	 * @return 随机数字串
	 */
	public static String getRandomNum(int length) {
		if (length <= 0) {
			return "";
		}
		char[] randomChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		Random random = new Random();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			stringBuffer.append(randomChar[Math.abs(random.nextInt()) % randomChar.length]);
		}
		return stringBuffer.toString();
	}

	public static String buildSmsMessageSn() {
		String uuid = UUID.randomUUID().toString();
		return SMS_SN_PREFIX + (uuid.substring(0, 8) + uuid.substring(9, 13)).toUpperCase();
	}

	/**
	 * 生成令牌，防止重复提交
	 * 
	 * @return
	 */
	public synchronized static String buildTokenSn() {
		String uuid = UUID.randomUUID().toString();
		return Math.random() + (uuid.substring(0, 8) + uuid.substring(9, 13)).toUpperCase();
	}

}
