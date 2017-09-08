package com.nt.framework.page;

import java.io.Serializable;

import com.nt.framework.enumType.OperatorEnum;

/**
 * 
 * @ClassName: SearchFilter
 * @Description: 筛选
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月8日 下午4:44:12
 */
public class SearchFilter implements Serializable {

	/**
	 * 属性
	 */
	private String property;

	/**
	 * 运算符
	 */
	private OperatorEnum operator;

	/**
	 * 值
	 */
	private Object value;

	/**
	 * 是否忽略大小写
	 */
	private Boolean ignoreCase = false;

	/**
	 * 初始化创建一个filter
	 * 
	 * @Title:SearchFilter
	 * @Description:TODO
	 */
	public SearchFilter() {
	}

	/**
	 * 
	 * @Title:SearchFilter
	 * @Description: 初始化创建一个filter
	 * @param property
	 *            属性
	 * @param operator
	 *            操作符
	 * @param value
	 *            值
	 * @param ignoreCase
	 *            忽略大小写
	 */
	public SearchFilter(String property, OperatorEnum operator, Object value, Boolean ignoreCase) {
		super();
		this.property = property;
		this.operator = operator;
		this.value = value;
		this.ignoreCase = ignoreCase;
	}

	/**
	 * 
	 * @Title:SearchFilter
	 * @Description:初始化创建一个filter
	 * @param property
	 *            属性
	 * @param operator
	 *            操作符
	 * @param value
	 *            值
	 */
	public SearchFilter(String property, OperatorEnum operator, Object value) {
		super();
		this.property = property;
		this.operator = operator;
		this.value = value;
	}

}
