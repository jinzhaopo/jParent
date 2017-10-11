package com.nt.framework.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @ClassName: RegexValidateUtil
 * @Description: 正则表达式的验证
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年10月11日 上午10:48:23
 */
public class RegexValidateUtil {
	/**
	 * 邮箱验证
	 */
	public static final String EMAIL_REGEX = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	/**
	 * 移动手机验证
	 */
	public static final String MOBILE_PHONE_REGEX = "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";

	/**
	 * 
	 * @Title: checkEmail
	 * @Description: 验证邮箱
	 * @param email
	 * @return
	 * @return: boolean
	 */
	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			String check = EMAIL_REGEX;
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(email);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 
	 * @Title: checkMobileNumber
	 * @Description: 验证手机号码
	 * @param mobileNumber
	 * @return
	 * @return: boolean
	 */
	public static boolean checkMobileNumber(String mobileNumber) {
		boolean flag = false;
		try {
			Pattern regex = Pattern.compile(MOBILE_PHONE_REGEX);
			Matcher matcher = regex.matcher(mobileNumber);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}
