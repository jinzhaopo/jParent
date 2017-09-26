package com.nt.framework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.framework.mapper.BaseLogMapper;
import com.nt.framework.model.BaseLog;
import com.nt.framework.page.SearchFilter;
import com.nt.framework.service.BaseLogService;

/**
 * 
 * @ClassName: LogServiceImpl
 * @Description: 日志实现类--service
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月25日 下午2:06:52
 */
@Service
public class BaseLogServiceImpl extends BaseServiceImpl<BaseLog> implements BaseLogService {

	@Autowired
	protected void setMapper(BaseLogMapper mapper) {
		super.setMapper(mapper);
	}

	/**
	 * 
	 * @Title: clear
	 * @Description: 清空日志
	 * @see com.nt.framework.service.LogService#clear()
	 */
	@Override
	public void clear() {
		deleteByExample(SearchFilter.isNotNull("id"));
	}
}
