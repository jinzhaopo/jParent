package com.nt.framework.service.impl;

import java.util.List;

import com.nt.framework.model.Entity;
import com.nt.framework.service.BaseService;

/**
 * 
 * @ClassName: BaseServiceImpl
 * @Description: 基础实现类
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月12日 上午9:19:44
 * @param <T>
 */
public class BaseServiceImpl<T extends Entity> implements BaseService<T> {

	@Override
	public void udpate(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSelective(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveSelective(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveList(List<T> ts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveUseGeneratedKeys(T t) {
		// TODO Auto-generated method stub
		
	}


}
