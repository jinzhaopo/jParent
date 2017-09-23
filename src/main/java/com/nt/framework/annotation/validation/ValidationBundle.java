package com.nt.framework.annotation.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @ClassName: ValidationBundle
 * @Description: 加载验证插件
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月22日 上午10:22:12
 */
public class ValidationBundle {

	private List<IValidate> iValidates;// 验证的插件接口

	public List<IValidate> getiValidates() {
		return iValidates;
	}

	public void setiValidates(List<IValidate> iValidates) {
		this.iValidates = iValidates;
	}

	/**
	 * 
	 * @Title: registerValidates
	 * @Description: 注册验证插件
	 * @param iValidates
	 * @return: void
	 */
	public void registerValidates(IValidate... iValidates) {
		if (this.iValidates == null) {
			this.iValidates = new ArrayList<IValidate>();
		}
		Collections.addAll(this.iValidates, iValidates);
	}

	/**
	 * 
	 * @Title: unRegisterPlugin
	 * @Description: 注销插件
	 * @param iValidates
	 * @return: void
	 */
	public void unRegisterPlugin(IValidate... iValidates) {
		for (IValidate iValidate : iValidates) {
			this.iValidates.remove(iValidate);
		}
	}
}
