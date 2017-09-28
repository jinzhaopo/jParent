package com.nt.framework.util;

import com.nt.framework.Setting;

/**
 * 
 * @ClassName: SettingUtils
 * @Description: setting的工具类
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月27日 下午3:48:28
 */
public class SettingUtils extends Setting {
	private static final long serialVersionUID = 1402688885716157220L;

	private static Setting setting = null;

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
	 * 
	 * @Title: setSetting
	 * @Description: 设置setting
	 * @param setting
	 * @return: void
	 */
	public static void setSetting(Setting setting) {
		SettingUtils.setting = setting;
	}
}
