package com.nt.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import com.nt.framework.constants.Constant;

/**
 * 
 * @ClassName: DateUtils
 * @Description: 日期处理工具类
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月26日 下午4:40:28
 */
public class DateHelpers {
	/**
	 * 
	 * @Title: getDate
	 * @Description: 将日期字符串变成日期
	 * @param dateStr
	 * @return
	 * @return: Date
	 */
	public static Date getDate(String dateStr) {
		Date date = new Date();
		try {
			date = DateUtils.parseDate(dateStr, Constant.DATE_PATTERNS);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 
	 * @Title: getString
	 * @Description: 将传入的Date以某种格式变成String
	 * @param date
	 * @param pattern
	 * @return
	 * @return: String
	 */
	public static String getString(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 
	 * @Title: getStringByPattern
	 * @Description: 获取日期的String格式,默认以yyyy-MM-dd的格式
	 * @param date
	 * @return
	 * @return: String
	 */
	public static String getStringByPattern(Date date) {
		return getString(date, Constant.YYYY_MM_DD);
	}

}
