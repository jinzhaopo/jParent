package com.nt.framework;

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
	 * 添加成功的提示
	 */
	public static final String MESSAGE_SUCCESS_SAVE = "message.success.save";
	/**
	 * 删除成功的提示
	 */
	public static final String MESSAGE_SUCCESS_DELETE = "message.success.delete";
	/**
	 * 修改成功的提示
	 */
	public static final String MESSAGE_SUCCESS_UPDATE = "message.success.update";
	/**
	 * 添加警告的提示
	 */
	public static final String MESSAGE_WARN_SAVE = "message.warn.save";
	/**
	 * 删除有误的提示
	 */
	public static final String MESSAGE_WARN_DELETE = "message.warn.delete";
	/**
	 * 修改有误的提示
	 */
	public static final String MESSAGE_WARN_UPDATE = "message.warn.update";

	/**
	 * 添加失败的提示
	 */
	public static final String MESSAGE_ERROR_SAVE = "message.error.save";
	/**
	 * 删除失败的提示
	 */
	public static final String MESSAGE_ERROR_DELETE = "message_error_delete";
	/**
	 * 更新错误
	 */
	public static final String Message_ERROR_UPDATE = "message_error_update";
	/**
	 * 是在request里面传递的
	 */
	public static final String WEBERRORS = "WebErrors";

}
