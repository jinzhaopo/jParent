package com.nt.framework.service;

import java.util.List;

import com.nt.framework.model.Entity;
import com.nt.framework.page.Order;
import com.nt.framework.page.Page;
import com.nt.framework.page.SearchFilter;

/**
 * 
 * @ClassName: BaseSelectService
 * @Description: 查询基础Service
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月12日 上午9:02:16
 * @param <T>
 */
public interface BaseSelectService<T extends Entity> {
	/**
	 * 
	 * @Title: get
	 * @Description: 根据属性进行查询
	 * @param property
	 * @param value
	 * @return
	 * @return: T
	 */
	T get(String property, Object value);

	/**
	 * 
	 * @Title: get
	 * @Description: 根据实体中的属性值进行查询，查询条件使用等号
	 * @param t
	 * @return
	 * @return: T
	 */
	T get(T t);

	/**
	 * 
	 * @Title: getAll
	 * @Description: 查询全部结果
	 * @return
	 * @return: List<T>
	 */
	List<T> getAll();

	/**
	 * 
	 * @Title: getList
	 * @Description: 根据条件查询
	 * @param filters
	 * @return
	 * @return: List<T>
	 */
	List<T> getList(SearchFilter... filters);

	/**
	 * 
	 * @Title: getList
	 * @Description: 根据条件查询
	 * @param property
	 * @param value
	 * @return
	 * @return: List<T>
	 */
	List<T> getList(String property, Object value);

	/**
	 * 
	 * @Title: getList
	 * @Description: 根据条件查询排序
	 * @param filters
	 * @param orders
	 * @return
	 * @return: List<T>
	 */
	List<T> getList(List<SearchFilter> filters, List<Order> orders);

	/**
	 * 
	 * @Title: getList
	 * @Description: 根据条件查找 ,用==进行匹配
	 * @param t
	 * @return
	 * @return: List<T>
	 */
	List<T> getList(T t);

	/**
	 * 
	 * @Title: get
	 * @Description: 根据主键查找
	 * @param id
	 * @return
	 * @return: T
	 */
	T get(Long id);

	/**
	 * 
	 * @Title: getList
	 * @Description: 根据ids进行查询
	 * @param ids
	 * @return
	 * @return: List<T>
	 */
	List<T> getList(List<Long> ids);

	/**
	 * 
	 * @Title: find
	 * @Description: 分页查询
	 * @param page
	 * @return
	 * @return: Page
	 */
	Page find(Page page);

}
