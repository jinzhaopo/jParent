package com.nt.framework.service;

import com.nt.framework.model.Entity;

import tk.mybatis.mapper.common.base.BaseSelectMapper;

/**
 * 
 * @ClassName: BaseService
 * @Description: 基础servie
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月12日 上午9:07:18
 * @param <T>
 */
public interface BaseService<T extends Entity> extends BaseSelectService<T>, BaseUpdateService<T>, BaseDeleteService<T>, BaseInsertService<T> {

	/**
	 * 
	 * @Title: isUnique
	 * @Description: 是否唯一
	 * @param property
	 * @param oldValue
	 * @param newValue
	 * @return
	 * @return: boolean
	 */
	public boolean isUnique(String property, String oldValue, String newValue);

}
