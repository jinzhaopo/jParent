package com.nt.framework.model;

import javax.persistence.OrderBy;

import org.apache.commons.lang3.builder.CompareToBuilder;

/**
 * 
 * @ClassName: PriorityEntity
 * @Description: 排序类的基类
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月8日 上午11:17:26
 */
@SuppressWarnings("rawtypes")
public abstract class PriorityEntity extends BaseEntity implements Comparable {
	private static final long serialVersionUID = -5236614399469983267L;
	/**
	 * 排序
	 */
	private Long priority;

	/*
	 * 重写方法 (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object obj) {
		return compareTo((PriorityEntity) obj);
	}

	/**
	 * 
	 * @Title: compareTo
	 * @Description: 实现compareTo方法
	 * @param priorityEntity
	 * @return
	 * @return: int
	 */
	public int compareTo(PriorityEntity priorityEntity) {
		return new CompareToBuilder().append(getPriority(), priorityEntity.getPriority()).append(getId(), priorityEntity.getId()).toComparison();
	}

	/**
	 * 获取排序字段
	 * 
	 * @return 排序
	 */
	public Long getPriority() {
		return priority;
	}

	/**
	 * 设置排序字段
	 * 
	 * @param order
	 *            排序
	 */
	public void setPriority(Long priority) {
		this.priority = priority;
	}
}
