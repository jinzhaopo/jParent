package com.nt.framework.interceptor;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.nt.framework.LogConfig;
import com.nt.framework.model.BaseLog;
import com.nt.framework.service.BaseLogService;
import com.nt.framework.util.SettingUtils;
import com.nt.framework.util.SpringUtils;

/**
 * 
 * @ClassName: LogInterceptor
 * @Description: Interceptor - 日志记录
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月25日 下午3:52:10
 */
public class LogInterceptor extends HandlerInterceptorAdapter {

	/** 默认忽略参数 */
	private static final String[] DEFAULT_IGNORE_PARAMETERS = new String[] { "password", "rePassword", "currentPassword" };

	/** antPathMatcher */
	private static AntPathMatcher antPathMatcher = new AntPathMatcher();

	/** 忽略参数 */
	private String[] ignoreParameters = DEFAULT_IGNORE_PARAMETERS;

	private BaseLogService baseLogService;

	public LogInterceptor() {
		super();
		this.baseLogService = (BaseLogService) SpringUtils.getBean("baseLogServiceImpl");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		List<LogConfig> logConfigs = SettingUtils.getSetting().getLogConfigs();
		if (logConfigs != null) {
			String path = request.getServletPath();
			for (LogConfig logConfig : logConfigs) {
				if (antPathMatcher.match(logConfig.getUrlPattern(), path)) {
					// String username = adminService.getCurrentUsername();
					String username = "默认测试";
					String operation = logConfig.getOperation();
					String operator = username;
					String content = (String) request.getAttribute(BaseLog.LOG_CONTENT_ATTRIBUTE_NAME);
					String ip = request.getRemoteAddr();
					request.removeAttribute(BaseLog.LOG_CONTENT_ATTRIBUTE_NAME);
					StringBuffer parameter = new StringBuffer();
					Map<String, String[]> parameterMap = request.getParameterMap();
					if (parameterMap != null) {
						for (Entry<String, String[]> entry : parameterMap.entrySet()) {
							String parameterName = entry.getKey();
							if (!ArrayUtils.contains(ignoreParameters, parameterName)) {
								String[] parameterValues = entry.getValue();
								if (parameterValues != null) {
									for (String parameterValue : parameterValues) {
										parameter.append(parameterName + " = " + parameterValue + "\n");
									}
								}
							}
						}
					}
					BaseLog log = new BaseLog();
					log.setOperation(operation);
					log.setOperator(operator);
					log.setContent(content);
					log.setParameter(parameter.toString());
					log.setIp(ip);
					baseLogService.save(log);
					break;
				}
			}
		}
	}

	/**
	 * 设置忽略参数
	 * 
	 * @return 忽略参数
	 */
	public String[] getIgnoreParameters() {
		return ignoreParameters;
	}

	/**
	 * 设置忽略参数
	 * 
	 * @param ignoreParameters
	 *            忽略参数
	 */
	public void setIgnoreParameters(String[] ignoreParameters) {
		this.ignoreParameters = ignoreParameters;
	}

}