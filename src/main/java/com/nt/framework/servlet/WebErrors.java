package com.nt.framework.servlet;

import java.util.ArrayList;
import java.util.List;

import com.nt.framework.util.LocaleMessageSourceUtils;

/**
 * 
 * @ClassName: WebError
 * @Description: 错误信息<br/>
 *               用来做错误拦截使用的
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月8日 上午11:23:17
 */
public class WebErrors {
	private List<String> errors;

	/**
	 * 通过HttpServletRequest创建error
	 * 
	 * @param request
	 *            从request中获得MessageSource和Locale，如果存在的话。
	 * @return 如果LocaleResolver存在则返回国际化WebErrors
	 */
	public static WebErrors create() {
		return new WebErrors();
	}

	/**
	 * 
	 * @Title: getErrors
	 * @Description: 错误列表
	 * @return
	 * @return: List<String>
	 */
	public List<String> getErrors() {
		if (errors == null) {
			errors = new ArrayList<String>();
		}
		return errors;
	}

	/**
	 * 
	 * @Title: addErrorCode
	 * @Description: 添加错误代码
	 * @param code
	 * @param args
	 * @return: void
	 */
	public void addErrorCode(String code, Object... args) {
		getErrors().add(LocaleMessageSourceUtils.getMessage(code, args));
	}

	/**
	 * 
	 * @Title: addErrorCode
	 * @Description: 添加错误代码
	 * @param code
	 * @return: void
	 */
	public void addErrorCode(String code) {
		getErrors().add(LocaleMessageSourceUtils.getMessage(code));
	}

	/**
	 * 
	 * @Title: addErrorString
	 * @Description: 添加错误字符串
	 * @param error
	 * @return: void
	 */
	public void addErrorString(String error) {
		getErrors().add(error);
	}

	/**
	 * 
	 * @Title: hasErrors
	 * @Description: 是否存在错误
	 * @return
	 * @return: boolean
	 */
	public boolean hasErrors() {
		return errors != null && errors.size() > 0;
	}

	/**
	 * 
	 * @Title: getCount
	 * @Description: 错误数量
	 * @return
	 * @return: int
	 */
	public int getCount() {
		return errors == null ? 0 : errors.size();
	}

}
