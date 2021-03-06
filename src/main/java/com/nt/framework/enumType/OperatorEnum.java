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
	EQ("="), NE("<>"), GT(">"), GE(">="), LT("<"), LE("<="), LIKE("like"), NOTLIKE("not like"), IN("in"), NOTIN("not in"), ISNULL("is null"), ISNOTNULL("is not null"), BT("between"), // 集合,大小为2
	NOTBT("not between"), // 集合,大小为2
	CONDITION("condition"), // 条件查询
	ENUM("enum");// 暂时没用

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
