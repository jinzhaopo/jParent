package com.nt.framework.service;

import com.nt.framework.model.Entity;

/**
 * 
 * @ClassName: BaseUpdateService
 * @Description: 更新基础service
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月12日 上午9:01:27
 * @param <T>
 */
public interface BaseUpdateService<T extends Entity> {

	/**
	 * 
	 * @Title: udpate
	 * @Description: 根据主键更新实体全部字段，null值会被更新
	 * @param t
	 * @return: void
	 */
	void udpate(T t);

	/**
	 * 
	 * @Title: updateSelective
	 * @Description: 根据主键更新属性不为null的值
	 * @param t
	 * @return: void
	 */
	void updateSelective(T t);
}
