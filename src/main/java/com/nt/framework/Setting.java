package com.nt.framework;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @ClassName: Setting
 * @Description: 这个类中的配置是可变的配置,通常是有默认值
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月22日 下午2:17:57
 */
public class Setting implements Serializable {

	private static Setting setting = null;

	private static final long serialVersionUID = 2266604316208785746L;

	private Setting() {
		super();
	}

	/**
	 * 
	 * @Title: getSetting
	 * @Description: 获取setting
	 * @return
	 * @return: Setting
	 */
	public static Setting getSetting() {
		if (setting == null) {
			setting = new Setting();
		}
		return setting;
	}

	/**
	 * 日志需要记录的url
	 */
	private List<LogConfig> logConfigs;

	public List<LogConfig> getLogConfigs() {
		return logConfigs;
	}

	public void setLogConfigs(List<LogConfig> logConfigs) {
		this.logConfigs = logConfigs;
	}

}
