package com.nt.framework.page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * 
 * @ClassName: Page
 * @Description: 分页主要继承了分页插件的pageINfo类
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年5月26日 下午1:56:36
 * @param <T>
 */
public class Page<T> extends PageInfo<T> {

	private static final long serialVersionUID = -5255811398198396881L;
	/**
	 * 过滤条件
	 */
	private List<SearchFilter> searchFilters;
	/**
	 * 样本排序
	 */
	private List<Order> orders;

	private static String DEFAULT_PROPERTY = "createDate";

	public Page() {
		super();
		// 初始化设置
		this.setPageNum(1);// 设置当前页码
		this.setPageSize(20);// 设置每页的记录数
		this.setTotal(0);// 设置总记录数
		this.setPages(0);// 设置总页数

		searchFilters = new ArrayList<SearchFilter>();
		orders = new ArrayList<Order>();

		// 默认排序createDate
		Order order = new Order();
		order.setProperty(DEFAULT_PROPERTY);
		orders.add(order);

	}

	/**
	 * 
	 * @Title: addOrders
	 * @Description: 添加排序
	 * @param order
	 * @return: void
	 */
	public void addOrders(Order... orders) {
		Collections.addAll(this.orders, orders);
	}

	/**
	 * 
	 * @Title: addSearchFilters
	 * @Description: 添加查询条件
	 * @param filters
	 * @return: void
	 */
	public void addSearchFilters(SearchFilter... filters) {
		Collections.addAll(this.searchFilters, filters);
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<SearchFilter> getSearchFilters() {
		return searchFilters;
	}

	public void setSearchFilters(List<SearchFilter> searchFilters) {
		this.searchFilters = searchFilters;
	}

}
