package com.nt.framework.enumType;

/**
 * 
 * @ClassName: OperatorEnum
 * @Description: 操作类型枚举:操作符号
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月8日 下午4:06:50
 */
public enum OperatorEnum {
	// =，类似，》，《，>=,<=,!=,
	EQ("="), LIKE("like"), GT(">"), LT("<"), NE("<>"), GE(">="), LE("<="), IN("in"), ISNULL("is null"), ISNOTNULL("is not null"), ENUM("enum"), NOTIN("not in");

	private OperatorEnum(String name) {
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
