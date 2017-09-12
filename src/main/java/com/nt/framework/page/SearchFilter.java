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

	/**
	 * 返回等于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 等于筛选
	 */
	public static SearchFilter eq(String property, Object value) {
		return new SearchFilter(property, OperatorEnum.EQ, value);
	}

	/**
	 * 返回等于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @param ignoreCase
	 *            忽略大小写
	 * @return 等于筛选
	 */
	public static SearchFilter eq(String property, Object value, boolean ignoreCase) {
		return new SearchFilter(property, OperatorEnum.EQ, value, ignoreCase);
	}

	/**
	 * 返回不等于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 不等于筛选
	 */
	public static SearchFilter ne(String property, Object value) {
		return new SearchFilter(property, OperatorEnum.NE, value);
	}

	/**
	 * 返回不等于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @param ignoreCase
	 *            忽略大小写
	 * @return 不等于筛选
	 */
	public static SearchFilter ne(String property, Object value, boolean ignoreCase) {
		return new SearchFilter(property, OperatorEnum.NE, value, ignoreCase);
	}

	/**
	 * 返回大于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 大于筛选
	 */
	public static SearchFilter gt(String property, Object value) {
		return new SearchFilter(property, OperatorEnum.GT, value);
	}

	/**
	 * 返回小于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 小于筛选
	 */
	public static SearchFilter lt(String property, Object value) {
		return new SearchFilter(property, OperatorEnum.LT, value);
	}

	/**
	 * 返回大于等于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 大于等于筛选
	 */
	public static SearchFilter ge(String property, Object value) {
		return new SearchFilter(property, OperatorEnum.GE, value);
	}

	/**
	 * 返回小于等于筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 小于等于筛选
	 */
	public static SearchFilter le(String property, Object value) {
		return new SearchFilter(property, OperatorEnum.LE, value);
	}

	/**
	 * 返回相似筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 相似筛选
	 */
	public static SearchFilter like(String property, Object value) {
		return new SearchFilter(property, OperatorEnum.LIKE, value);
	}

	/**
	 * 返回包含筛选
	 * 
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @return 包含筛选
	 */
	public static SearchFilter in(String property, Object value) {
		return new SearchFilter(property, OperatorEnum.IN, value);
	}

	/**
	 * 返回为Null筛选
	 * 
	 * @param property
	 *            属性
	 * @return 为Null筛选
	 */
	public static SearchFilter isNull(String property) {
		return new SearchFilter(property, OperatorEnum.ISNULL, null);
	}

	/**
	 * 返回不为Null筛选
	 * 
	 * @param property
	 *            属性
	 * @return 不为Null筛选
	 */
	public static SearchFilter isNotNull(String property) {
		return new SearchFilter(property, OperatorEnum.ISNOTNULL, null);
	}

	/**
	 * 
	 * @Title: notIn
	 * @Description: 返回不包含的筛选
	 * @param property
	 * @param value
	 * @return
	 * @return: SearchFilter
	 */
	public static SearchFilter notIn(String property, Object value) {
		return new SearchFilter(property, OperatorEnum.NOTIN, value);
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public OperatorEnum getOperator() {
		return operator;
	}

	public void setOperator(OperatorEnum operator) {
		this.operator = operator;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Boolean getIgnoreCase() {
		return ignoreCase;
	}

	public void setIgnoreCase(Boolean ignoreCase) {
		this.ignoreCase = ignoreCase;
	}

}
