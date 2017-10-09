package com.nt.framework.config.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.nt.framework.Setting;
import com.nt.framework.util.SettingUtils;

/**
 * 
 * @ClassName: CacheConfiguration
 * @Description: 缓存<br/>
 * @CacheEvict(value=DEMO_CACHE_NAME,key=CACHE_KEY) 保存数据<br>
 * @Cacheable(value=DEMO_CACHE_NAME,key="'demoInfo_'+#id") 查询数据使用缓存<br>
 * @CachePut(value = DEMO_CACHE_NAME,key = "'demoInfo_'+#updated.getId()") 修改数据
 *                 <br>
 *                 在支持Spring Cache的环境下，对于使用@Cacheable标注的方法，
 *                 Spring在每次执行前都会检查Cache中是否存在相同key的缓存元素，如果存在就不再执行该方法，
 *                 而是直接从缓存中获取结果进行返回，
 *                 否则才会执行并将返回结果存入指定的缓存中。 @CachePut也可以声明一个方法支持缓存功能。
 *                 与@Cacheable不同的是使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，
 *                 而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
 * @CacheEvict(value = DEMO_CACHE_NAME,key = "'demoInfo_'+#id") 清楚
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年10月9日 下午5:41:19
 */
@Configuration
@EnableCaching // 标注启动缓存.
public class CacheConfiguration {

	/**
	 * 
	 * @Title: ehCacheCacheManager
	 * @Description: ehcache 主要的管理器
	 * @param bean
	 * @return
	 * @return: EhCacheCacheManager
	 */
	@Bean
	public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean) {
		return new EhCacheCacheManager(bean.getObject());

	}

	/**
	 * 
	 * @Title: ehCacheManagerFactoryBean
	 * @Description: 据shared与否的设置,Spring分别通过CacheManager.create()或new
	 *               CacheManager()方式来创建一个ehcache基地.
	 *               也说是说通过这个来设置cache的基地是这里的Spring独用,还是跟别的(如hibernate的Ehcache共享)
	 * @return
	 * @return: EhCacheManagerFactoryBean
	 */
	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
		EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		cacheManagerFactoryBean.setConfigLocation(new ClassPathResource(SettingUtils.getSetting().getEhcacheXmlPath()));
		cacheManagerFactoryBean.setShared(SettingUtils.getSetting().getEhcacheShared());
		return cacheManagerFactoryBean;

	}

}
