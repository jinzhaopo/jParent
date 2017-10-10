package com.nt.framework.constants;

/**
 * 
 * @ClassName: Constant
 * @Description: 常量类,这个类中的配置是不可变的配置,为常量
 * @author: zhaopo
 * @date: 2016年11月3日 下午3:42:12
 */
public final class Constant {
	/**
	 * 
	 * @Title:Constant
	 * @Description:不能被实例化
	 */
	private Constant() {
	}

	/** 日期格式配比 */
	public static final String[] DATE_PATTERNS = new String[] { "yyyy", "yyyy-MM", "yyyyMM", "yyyy/MM", "yyyy-MM-dd", "yyyyMMdd", "yyyy/MM/dd", "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss", "yyyy/MM/dd HH:mm:ss" };
	/**
	 * 日期的格式
	 */
	public static final String YYYYMM = "yyyyMM";
	/**
	 * 日期格式
	 */
	public static final String YYYY_MM_DD = "YYYY-MM-dd";
	/**
	 * 分割的逗号
	 */
	public static final String SEPARATOR = ",";

	/**
	 * 是在request里面传递的
	 */
	public static final String WEBERRORS = "WebErrors";
	/**
	 * 验证码分隔符
	 */
	public static final String VERIFY_CODE_KEY_SEPARATOR = "_";

	/**
	 * 动态密码过期时间间隔
	 */
	public static final int DYNAMIC_PASSWORD_PERIOD = 10;

}
