package com.nt.framework;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.nt.framework.constants.Constant;
import com.nt.framework.util.DateHelpers;

/**
 * 
 * @ClassName: Setting
 * @Description: 这个类中的配置是可变的配置,通常是有默认值
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月22日 下午2:17:57
 */
public class Setting implements Serializable {

	private static final long serialVersionUID = 2266604316208785746L;

	public Setting() {
		super();
	}

	/**
	 * 日志需要记录的url
	 */
	private List<LogConfig> logConfigs;

	// 网站设置
	/** 网站名称 */
	private String siteName = "牛逼的网站";

	/** 网站网址 */
	private String siteUrl = "http://localhost";

	// task 设置
	private int corePoolSize = 5;

	private int maxPoolSize = 50;

	private int queueCapacity = 1000;

	private int keepAliveSeconds = 60;

	// upload setting
	/**
	 * 文件上传的最大限制
	 */
	private Integer uploadMaxSize = 10;
	/**
	 * 允许文件上传的扩展名
	 */
	private String uploadImageExtension = "jpg,jpeg,bmp,gif,png";

	/**
	 * 允许flash上传的扩展名
	 */
	private String uploadFlashExtension = "swf,flv";
	/**
	 * 允许媒体上传的扩展名称
	 */
	private String uploadMediaExtension = "swf,flv,mp3,wav,avi,rm,rmvb";
	/**
	 * 允许文件上传的扩展名
	 */
	private String uploadFileExtension = "zip,rar,7z,doc,docx,xls,xlsx,ppt,pptx";
	/**
	 * 图片上传的的地址
	 */
	private String imageUploadPath = "/upload/image/";
	/**
	 * flash上传的地址
	 */
	private String flashUploadPath = "/upload/flash/";
	/**
	 * 媒体上传的地址
	 */
	private String mediaUploadPath = "/upload/media/";
	/**
	 * 文件上传的地址
	 */
	private String fileUploadPath = "/upload/file/";

	// freemarker配置
	/**
	 * 指定模版的位置
	 */
	private String[] templateLoaderPaths = new String[] { "/WEB-INF/templates", "classpath:/", "classpath:templates" };

	/**
	 * 数字显示的格式
	 */
	private String numberFormat = "0.\\#\\#\\#\\#\\#\\#";
	/**
	 * 日期显示的格式
	 */
	private String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 日期显示的格式
	 */
	private String dateFormat = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 时间现实的格式
	 */
	private String timeFormat = "HH\\:mm\\:ss";
	/**
	 * 布尔类型显示的格式
	 */
	private String booleanFormat = "true,false";

	private String updateDelay = "0";

	/**
	 * 编码格式
	 */
	private String encoding = "UTF-8";
	/**
	 * 后缀
	 */
	private String suffix = ".ftl";
	/**
	 * 标签导入
	 */
	private String autoImport = "/ftl/index.ftl as u";

	private String urlEscapingCharset = "UTF-8";
	/**
	 * 本地解析器
	 */
	private String locale = "zh_CN";

	// cache
	/**
	 * ehcache xml的配置存放的路径
	 */
	private String ehcacheXmlPath = "conf/ehcache.xml";
	/**
	 * 是否开启缓存
	 */
	private Boolean ehcacheShared = true;

	// freemarker
	/**
	 * freemarker模版的位置
	 */
	private String freemarkerTemplatePath = "";

	// 短信
	/**
	 * 短信工具类的包名
	 */
	private String smsClassName = "";
	/**
	 * 短信的方法名称
	 */
	private String smsMethodName = "sendSms";

	public String getSmsClassName() {
		return smsClassName;
	}

	public void setSmsClassName(String smsClassName) {
		this.smsClassName = smsClassName;
	}

	public String getSmsMethodName() {
		return smsMethodName;
	}

	public void setSmsMethodName(String smsMethodName) {
		this.smsMethodName = smsMethodName;
	}

	public String getFreemarkerTemplatePath() {
		return freemarkerTemplatePath;
	}

	public void setFreemarkerTemplatePath(String freemarkerTemplatePath) {
		this.freemarkerTemplatePath = freemarkerTemplatePath;
	}

	public Boolean getEhcacheShared() {
		return ehcacheShared;
	}

	public void setEhcacheShared(Boolean ehcacheShared) {
		this.ehcacheShared = ehcacheShared;
	}

	public String getEhcacheXmlPath() {
		return ehcacheXmlPath;
	}

	public void setEhcacheXmlPath(String ehcacheXmlPath) {
		this.ehcacheXmlPath = ehcacheXmlPath;
	}

	public String getDateTimeFormat() {
		return dateTimeFormat;
	}

	public void setDateTimeFormat(String dateTimeFormat) {
		this.dateTimeFormat = dateTimeFormat;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getTimeFormat() {
		return timeFormat;
	}

	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}

	public String getBooleanFormat() {
		return booleanFormat;
	}

	public void setBooleanFormat(String booleanFormat) {
		this.booleanFormat = booleanFormat;
	}

	public String getUpdateDelay() {
		return updateDelay;
	}

	public void setUpdateDelay(String updateDelay) {
		this.updateDelay = updateDelay;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getAutoImport() {
		return autoImport;
	}

	public void setAutoImport(String autoImport) {
		this.autoImport = autoImport;
	}

	public String getUrlEscapingCharset() {
		return urlEscapingCharset;
	}

	public void setUrlEscapingCharset(String urlEscapingCharset) {
		this.urlEscapingCharset = urlEscapingCharset;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getNumberFormat() {
		return numberFormat;
	}

	public void setNumberFormat(String numberFormat) {
		this.numberFormat = numberFormat;
	}

	public Integer getUploadMaxSize() {
		return uploadMaxSize;
	}

	public String[] getTemplateLoaderPaths() {
		return templateLoaderPaths;
	}

	public void setTemplateLoaderPaths(String[] templateLoaderPaths) {
		this.templateLoaderPaths = templateLoaderPaths;
	}

	public void setUploadMaxSize(Integer uploadMaxSize) {
		this.uploadMaxSize = uploadMaxSize;
	}

	public String getUploadImageExtension() {
		return uploadImageExtension;
	}

	public void setUploadImageExtension(String uploadImageExtension) {
		this.uploadImageExtension = uploadImageExtension;
	}

	public String getUploadFlashExtension() {
		return uploadFlashExtension;
	}

	public void setUploadFlashExtension(String uploadFlashExtension) {
		this.uploadFlashExtension = uploadFlashExtension;
	}

	public String getUploadMediaExtension() {
		return uploadMediaExtension;
	}

	public void setUploadMediaExtension(String uploadMediaExtension) {
		this.uploadMediaExtension = uploadMediaExtension;
	}

	public String getUploadFileExtension() {
		return uploadFileExtension;
	}

	public void setUploadFileExtension(String uploadFileExtension) {
		this.uploadFileExtension = uploadFileExtension;
	}

	public String getImageUploadPath() {
		return imageUploadPath + DateHelpers.getString(new Date(), Constant.YYYYMM);
	}

	public void setImageUploadPath(String imageUploadPath) {
		this.imageUploadPath = imageUploadPath;
	}

	public String getFlashUploadPath() {
		return flashUploadPath + DateHelpers.getString(new Date(), Constant.YYYYMM);
	}

	public void setFlashUploadPath(String flashUploadPath) {
		this.flashUploadPath = flashUploadPath;
	}

	public String getMediaUploadPath() {
		return mediaUploadPath + DateHelpers.getString(new Date(), Constant.YYYYMM);
	}

	public void setMediaUploadPath(String mediaUploadPath) {
		this.mediaUploadPath = mediaUploadPath;
	}

	public String getFileUploadPath() {
		return fileUploadPath + DateHelpers.getString(new Date(), Constant.YYYYMM);
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	public int getCorePoolSize() {
		return corePoolSize;
	}

	public void setCorePoolSize(int corePoolSize) {
		this.corePoolSize = corePoolSize;
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public int getQueueCapacity() {
		return queueCapacity;
	}

	public void setQueueCapacity(int queueCapacity) {
		this.queueCapacity = queueCapacity;
	}

	public int getKeepAliveSeconds() {
		return keepAliveSeconds;
	}

	public void setKeepAliveSeconds(int keepAliveSeconds) {
		this.keepAliveSeconds = keepAliveSeconds;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<LogConfig> getLogConfigs() {
		return logConfigs;
	}

	public void setLogConfigs(List<LogConfig> logConfigs) {
		this.logConfigs = logConfigs;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	/**
	 * 获取允许上传图片扩展名
	 * 
	 * @return 允许上传图片扩展名
	 */
	public String[] getUploadImageExtensions() {
		return StringUtils.split(uploadImageExtension, Constant.SEPARATOR);
	}

	/**
	 * 获取允许上传Flash扩展名
	 * 
	 * @return 允许上传Flash扩展名
	 */
	public String[] getUploadFlashExtensions() {
		return StringUtils.split(uploadFlashExtension, Constant.SEPARATOR);
	}

	/**
	 * 获取允许上传媒体扩展名
	 * 
	 * @return 允许上传媒体扩展名
	 */
	public String[] getUploadMediaExtensions() {
		return StringUtils.split(uploadMediaExtension, Constant.SEPARATOR);
	}

	/**
	 * 获取允许上传文件扩展名
	 * 
	 * @return 允许上传文件扩展名
	 */
	public String[] getUploadFileExtensions() {
		return StringUtils.split(uploadFileExtension, Constant.SEPARATOR);
	}
}
