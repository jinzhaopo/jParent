package com.nt.framework.mapper;

import java.util.List;
import java.util.Map;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 
 * @ClassName: MyMapper
 * @Description: 通用mapper<br/>
 *               因为使用mysql数据库 ，所以集成了mysql的mapper
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年8月31日 下午2:12:15
 * @param <T>
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
	// /**
	// * 获取表中的下一个id<br/>
	// * 由于mycat和mapper整合的时候ID主键策略有问题<br/>
	// * 所以先用这个来代替
	// *
	// * @return
	// */
	// Long selectNextId();

}
