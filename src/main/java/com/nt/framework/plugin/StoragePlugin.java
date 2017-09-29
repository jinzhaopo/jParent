package com.nt.framework.plugin;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.nt.framework.FileInfo;
import com.nt.framework.model.PluginConfig;
import com.nt.framework.model.PluginConfigAttribute;
import com.nt.framework.plugin.file.FilePlugin;
import com.nt.framework.service.PluginConfigAttributeService;
import com.nt.framework.service.PluginConfigService;
import com.nt.framework.util.SpringUtils;

/**
 * 
 * @ClassName: StoragePlugin
 * @Description: 存储插件---plugin
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月27日 上午11:27:38
 */
public abstract class StoragePlugin implements Comparable<StoragePlugin> {
	/**
	 * 查找的时候会根据这个进行pluginId的查询
	 */
	public static String[] KEYS = { "filePlugin" };

	@Autowired
	private PluginConfigService pluginConfigService;

	@Autowired
	private PluginConfigAttributeService pluginConfigAttributeService;

	public StoragePlugin() {
		super();
	}

	/**
	 * 
	 * @Title: getId
	 * @Description: 获取ID
	 * @return
	 * @return: String
	 */
	public final String getId() {
		return getClass().getAnnotation(Component.class).value();
	}

	/**
	 * 获取是否已安装
	 * 
	 * @return 是否已安装
	 */
	public boolean getIsInstalled() {
		return pluginConfigService.pluginIdExists(getId());
	}

	/**
	 * 获取插件配置
	 * 
	 * @return 插件配置
	 */
	public PluginConfig getPluginConfig() {
		return pluginConfigService.findByPluginId(getId());
	}

	/**
	 * 获取是否已启用
	 * 
	 * @return 是否已启用
	 */
	public boolean getIsEnabled() {
		PluginConfig pluginConfig = getPluginConfig();
		return pluginConfig != null ? pluginConfig.getEnabled() : false;
	}

	/**
	 * 
	 * @Title: getPriority
	 * @Description: 获取排序
	 * @return
	 * @return: Long
	 */
	public Long getPriority() {
		PluginConfig pluginConfig = getPluginConfig();
		return pluginConfig.getPriority();
	}

	/**
	 * 获取属性值
	 * 
	 * @param name
	 *            属性名称
	 * @return 属性值
	 */
	public String getAttribute(String name) {
		PluginConfig pluginConfig = getPluginConfig();
		PluginConfigAttribute byPluginConfigIdAndName = pluginConfigAttributeService.getByPluginConfigIdAndName(pluginConfig.getId(), name);
		return byPluginConfigIdAndName != null ? byPluginConfigIdAndName.getName() : null;
	}

	/**
	 * 获取名称
	 * 
	 * @return 名称
	 */
	public abstract String getName();

	/**
	 * 获取版本
	 * 
	 * @return 版本
	 */
	public abstract String getVersion();

	/**
	 * 获取作者
	 * 
	 * @return 作者
	 */
	public abstract String getAuthor();

	/**
	 * 获取网址
	 * 
	 * @return 网址
	 */
	public abstract String getSiteUrl();

	/**
	 * 获取安装URL
	 * 
	 * @return 安装URL
	 */
	public abstract String getInstallUrl();

	/**
	 * 获取卸载URL
	 * 
	 * @return 卸载URL
	 */
	public abstract String getUninstallUrl();

	/**
	 * 获取设置URL
	 * 
	 * @return 设置URL
	 */
	public abstract String getSettingUrl();

	/**
	 * 文件上传
	 * 
	 * @param path
	 *            上传路径
	 * @param file
	 *            上传文件
	 * @param contentType
	 *            文件类型
	 */
	public abstract void upload(String path, File file, String contentType);

	/**
	 * 获取访问URL
	 * 
	 * @param path
	 *            上传路径
	 * @return 访问URL
	 */
	public abstract String getUrl(String path);

	/**
	 * 文件浏览
	 * 
	 * @param path
	 *            浏览路径
	 * @return 文件信息
	 */
	public abstract List<FileInfo> browser(String path);

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		StoragePlugin other = (StoragePlugin) obj;
		return new EqualsBuilder().append(getId(), other.getId()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(getId()).toHashCode();
	}

	public int compareTo(StoragePlugin storagePlugin) {
		return new CompareToBuilder().append(getPriority(), storagePlugin.getPriority()).append(getId(), storagePlugin.getId()).toComparison();
	}
}
