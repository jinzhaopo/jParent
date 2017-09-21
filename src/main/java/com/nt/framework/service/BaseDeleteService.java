package com.nt.framework.service;

import java.util.List;

import com.nt.framework.model.Entity;
import com.nt.framework.page.SearchFilter;

/**
 * 
 * @ClassName: BaseDeleteService
 * @Description: 删除基础service
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月12日 上午8:55:32
 * @param <T>
 */
public interface BaseDeleteService<T extends Entity> {
	/**
	 * 
	 * @Title: delete
	 * @Description: 根据实体属性作为条件进行删除，查询条件使用等号
	 * @param t
	 * @return
	 * @return: int
	 */
	int delete(T t);

	/**
	 * 
	 * @Title: deleteByPrimaryKey
	 * @Description: deleteByPrimaryKey
	 * @param t
	 * @return
	 * @return: int
	 */
	int deleteByPrimaryKey(Long id);
	/**
	 * 
	 * @Title: deleteByPrimaryKeys
	 * @Description: 通过主键集合删除
	 * @param ids
	 * @return
	 * @return: int
	 */
	int deleteByPrimaryKeys(List<Long> ids);

	/**
	 * 
	 * @Title: deleteByExample
	 * @Description: 根据filters条件删除数据
	 * @param filters
	 * @return
	 * @return: int
	 */
	int deleteByExample(SearchFilter... filters);
}
