package com.nt.framework.service;

import com.nt.framework.model.Entity;
import com.nt.framework.page.SearchFilter;

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
	 * @return: int
	 */
	int updateByPrimaryKey(T t);

	/**
	 * 
	 * @Title: updateByPrimaryKeySelective
	 * @Description: 根据主键更新属性不为null的值
	 * @param t
	 * @return
	 * @return: int
	 */
	int updateByPrimaryKeySelective(T t);

	/**
	 * 
	 * @Title: updateByExample
	 * @Description: 根据Example条件更新实体`record`包含的全部属性，null值会被更新
	 * @param t
	 * @param filters
	 * @return
	 * @return: int
	 */
	int updateByExample(T t, SearchFilter... filters);

	/**
	 * 
	 * @Title: updateByExampleSelective
	 * @Description: 根据Example条件更新实体`record`包含的不是null的属性值
	 * @param t
	 * @param filters
	 * @return
	 * @return: int
	 */
	int updateByExampleSelective(T t, SearchFilter... filters);

}
