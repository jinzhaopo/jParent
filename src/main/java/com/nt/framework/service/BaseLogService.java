package com.nt.framework.service;

import com.nt.framework.model.BaseLog;

/**
 * 
 * @ClassName: BaseLogService
 * @Description: 日志-Service
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月25日 下午2:03:42
 */
public interface BaseLogService extends BaseService<BaseLog> {
	/**
	 * 
	 * @Title: clear
	 * @Description: 清空日志
	 * @return: void
	 */
	void clear();
}
