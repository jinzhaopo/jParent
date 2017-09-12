package com.nt.framework.service;

import java.util.List;

import com.nt.framework.model.Entity;

/**
 * 
 * @ClassName: BaseInsertService
 * @Description: 新增基础service
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月12日 上午8:54:01
 * @param <T>
 */
public interface BaseInsertService<T extends Entity> {
	/**
	 * 
	 * @Title: save
	 * @Description: 保存一个实体，null的属性也会保存，不会使用数据库默认值
	 * @param t
	 * @return: void
	 */
	void save(T t);

	/**
	 * 
	 * @Title: saveSelective
	 * @Description: 保存一个实体，null的属性不会保存，会使用数据库默认值
	 * @param t
	 * @return: void
	 */
	void saveSelective(T t);

	/**
	 * 
	 * @Title: saveList
	 * @Description: 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含`id`属性并且必须为自增列
	 * @param ts
	 * @return: void
	 */
	void saveList(List<T> ts);

	/**
	 * 
	 * @Title: saveUseGeneratedKeys
	 * @Description: 插入数据，限制为实体包含`id`属性并且必须为自增列，实体配置的主键策略无效
	 * @param t
	 * @return: void
	 */
	void saveUseGeneratedKeys(T t);
}
