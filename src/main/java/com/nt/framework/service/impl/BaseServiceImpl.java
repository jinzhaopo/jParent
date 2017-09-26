package com.nt.framework.service.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.github.pagehelper.PageHelper;
import com.nt.framework.enumType.OperatorEnum;
import com.nt.framework.model.BaseEntity;
import com.nt.framework.model.Entity;
import com.nt.framework.model.PriorityEntity;
import com.nt.framework.page.Order;
import com.nt.framework.page.Page;
import com.nt.framework.page.SearchFilter;
import com.nt.framework.service.BaseService;
import com.nt.framework.tkMapper.MyMapper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
import tk.mybatis.mapper.entity.Example.OrderBy;

/**
 * 
 * @ClassName: BaseServiceImpl
 * @Description: 基础实现类
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月12日 上午9:19:44
 * @param <T>
 */
public abstract class BaseServiceImpl<T extends Entity> implements BaseService<T> {

	private static String DEFAULT_PRIORITY = "priority";
	private static String DEFAULT_CREATEDATE = "createDate";

	private MyMapper<T> mapper;

	/**
	 * 
	 * @Title: setMapper
	 * @Description: 设置mapper
	 * @param obj
	 * @return: void
	 */
	protected void setMapper(MyMapper<T> mapper) {
		this.mapper = mapper;
	}

	/**
	 * 
	 * @Title: getTClass
	 * @Description: 获取实体类的class对象
	 * @return
	 * @return: Class
	 */
	@SuppressWarnings("rawtypes")
	private Class getTClass() {

		// 返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。
		Type genType = getClass().getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		// 返回表示此类型实际类型参数的 Type 对象的数组。
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		return (Class) params[0];
	}

	/**
	 * 
	 * @Title: get
	 * @Description: 根据属性值进行查询，查询条件使用等号
	 * @param property
	 * @param value
	 * @return
	 * @see com.nt.framework.service.BaseSelectService#get(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public T get(String property, Object value) {
		List<T> list = getList(property, value);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 
	 * @Title: get
	 * @Description: 根据实体中的属性值进行查询，查询条件使用等号
	 * @param t
	 * @return
	 * @see com.nt.framework.service.BaseSelectService#get(com.nt.framework.model.Entity)
	 */
	@Override
	public T get(T t) {
		return mapper.selectOne(t);
	}

	/**
	 * 
	 * @Title: getAll
	 * @Description: 查询所有的数据
	 * @return
	 * @see com.nt.framework.service.BaseSelectService#getAll()
	 */
	@Override
	public List<T> getAll() {
		return mapper.selectAll();
	}

	/**
	 * 
	 * @Title: getList
	 * @Description: 获取查询条件的集合
	 * @param filters
	 * @return
	 * @see com.nt.framework.service.BaseSelectService#getList(com.nt.framework.page.SearchFilter[])
	 */
	@Override
	public List<T> getList(SearchFilter... filters) {
		Example example = getExample(null, getSearchFilters(filters), null);
		return mapper.selectByExample(example);
	}

	/**
	 * 
	 * @Title: getList
	 * @Description: 根据条件进行查询
	 * @param property
	 * @param value
	 * @return
	 * @see com.nt.framework.service.BaseSelectService#getList(java.lang.String,
	 *      java.lang.Object)
	 */
	@Override
	public List<T> getList(String property, Object value) {
		return getList(SearchFilter.eq(property, value));
	}

	/**
	 * 
	 * @Title: getList
	 * @Description: 获取查询条件的集合
	 * @param filters
	 * @param orders
	 * @return
	 * @return: List<T>
	 */
	@Override
	public List<T> getList(List<SearchFilter> filters, List<Order> orders) {
		Example example = getExample(null, filters, orders);
		return mapper.selectByExample(example);

	}

	/**
	 * 
	 * @Title: getList
	 * @Description: 根据条件查找 ,用==进行匹配
	 * @param t
	 * @return
	 * @see com.nt.framework.service.BaseSelectService#getList(com.nt.framework.model.Entity)
	 */
	@Override
	public List<T> getList(T t) {
		return mapper.select(t);
	}

	/**
	 * 
	 * @Title: get
	 * @Description: 根据主键查找
	 * @param id
	 * @return
	 * @see com.nt.framework.service.BaseSelectService#get(java.lang.Long)
	 */
	@Override
	public T get(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	/**
	 * 
	 * @Title: getList
	 * @Description: 根据主键s进行查找
	 * @param ids
	 * @return
	 * @see com.nt.framework.service.BaseSelectService#getList(java.util.List)
	 */
	@Override
	public List<T> getList(List<Long> ids) {
		List<SearchFilter> searchFilters = new ArrayList<SearchFilter>();
		searchFilters.add(SearchFilter.in("id", ids));
		Example example = getExample(null, searchFilters, null);
		return mapper.selectByExample(example);

	}

	/**
	 * 
	 * @Title: find
	 * @Description: 分页查询
	 * @param page
	 * @return
	 * @see com.nt.framework.service.BaseSelectService#find(com.nt.framework.page.Page)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page find(Page page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List list = getList(page.getSearchFilters(), page.getOrders());
		page.setList(list);
		return page;
	}

	/**
	 * 
	 * @Title: updateByPrimaryKey
	 * @Description: 根据主键更新实体全部字段，null值会被更新
	 * @param t
	 * @return
	 * @return: int
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKey(T t) {
		setModifyDate(t);
		return mapper.updateByPrimaryKey(t);
	}

	/**
	 * 
	 * @Title: updateByPrimaryKeySelective
	 * @Description: 根据主键更新属性不为null的值
	 * @param t
	 * @return
	 * @return: int
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKeySelective(T t) {
		setModifyDate(t);
		return mapper.updateByPrimaryKeySelective(t);
	}

	/**
	 * 
	 * @Title: updateByExample
	 * @Description: 根据Example条件更新实体`record`包含的全部属性，null值会被更新
	 * @param t
	 * @param filters
	 * @return
	 * @return: int
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByExample(T t, SearchFilter... filters) {
		Example example = getExample(null, getSearchFilters(filters), null);
		setModifyDate(t);
		return mapper.updateByExample(t, example);
	}

	/**
	 * 
	 * @Title: updateByExampleSelective
	 * @Description: 根据Example条件更新实体`record`包含的不是null的属性值
	 * @param t
	 * @param filters
	 * @return
	 * @return: int
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByExampleSelective(T t, SearchFilter... filters) {
		Example example = getExample(null, getSearchFilters(filters), null);
		setModifyDate(t);
		return mapper.updateByExampleSelective(t, example);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: 根据实体属性作为条件进行删除，查询条件使用等号
	 * @param t
	 * @return
	 * @return: int
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int delete(T t) {
		return mapper.delete(t);
	}

	/**
	 * 
	 * @Title: deleteByPrimaryKey
	 * @Description: 根据主键字段进行删除，方法参数必须包含完整的主键属性
	 * @param id
	 * @return
	 * @return: int
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	/**
	 * 
	 * @Title: deleteByPrimaryKeys
	 * @Description: 通过主键集合进行删除
	 * @param ids
	 * @return
	 * @see com.nt.framework.service.BaseDeleteService#deleteByPrimaryKeys(java.util.List)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteByPrimaryKeys(List<Long> ids) {
		return deleteByExample(SearchFilter.in("id", ids));
	}

	/**
	 * 
	 * @Title: deleteByExample
	 * @Description: 根据Example条件删除数据
	 * @param filters
	 * @return
	 * @return: int
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteByExample(SearchFilter... filters) {
		Example example = getExample(null, getSearchFilters(filters), null);
		return mapper.deleteByExample(example);
	}

	/**
	 * 
	 * @Title: save
	 * @Description: 保存一个实体，null的属性也会保存，不会使用数据库默认值
	 * @param t
	 * @see com.nt.framework.service.BaseInsertService#save(com.nt.framework.model.Entity)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(T t) {
		setCreateDate(t);
		mapper.insert(t);
	}

	/**
	 * 
	 * @Title: saveSelective
	 * @Description: 保存一个实体，null的属性不会保存，会使用数据库默认值
	 * @param t
	 * @return: void
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveSelective(T t) {
		setCreateDate(t);
		mapper.insertSelective(t);
	}

	/**
	 * 
	 * @Title: saveList
	 * @Description: 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含`id`属性并且必须为自增列
	 * @param ts
	 * @return: void
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveList(List<T> ts) {
		for (T t : ts) {
			setCreateDate(t);
		}
		mapper.insertList(ts);
	}

	/**
	 * 
	 * @Title: saveUseGeneratedKeys
	 * @Description: 插入数据，限制为实体包含`id`属性并且必须为自增列，实体配置的主键策略无效
	 * @param t
	 * @return: void
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveUseGeneratedKeys(T t) {
		setCreateDate(t);
		mapper.insertUseGeneratedKeys(t);

	}

	/**
	 * 
	 * @Title: isUnique
	 * @Description: 是否唯一
	 * @param property
	 * @param oldValue
	 * @param newValue
	 * @return
	 * @return: boolean
	 */
	@Override
	public boolean isUnique(String property, String oldValue, String newValue) {
		Assert.hasText(property, "propertyName must not be empty");
		Assert.notNull(newValue, "newValue is required");
		if (newValue == oldValue || newValue.equals(oldValue)) {
			return true;
		}
		if (newValue instanceof String) {
			if (oldValue != null && StringUtils.equalsIgnoreCase((String) oldValue, (String) newValue)) {
				return true;
			}
		}
		T t = get(property, newValue);
		return (t == null);
	}

	/**
	 * 
	 * @Title: getExample
	 * @Description: 获取查询的getEacmple
	 * @param example
	 * @param filters
	 * @param orders
	 * @return
	 * @return: Example
	 */
	@SuppressWarnings("rawtypes")
	private Example getExample(Example example, List<SearchFilter> searchFilters, List<Order> orders) {
		Class _class = getTClass();
		if (example == null) {
			new Example(_class);
		}
		if (orders == null) {
			orders = new ArrayList<Order>();
		}
		setSearchFilters(example, searchFilters);

		// 判断createDate prioprity
		boolean hasCreateDate = false;
		boolean hasPriority = false;
		for (Order order : orders) {
			if (DEFAULT_CREATEDATE.equals(order.getProperty())) {
				hasCreateDate = true;
			}
			if (DEFAULT_PRIORITY.equals(order.getProperty())) {
				hasPriority = true;
			}
		}

		try {
			if (!hasPriority && _class.newInstance() instanceof PriorityEntity) {
				orders.add(Order.asc(DEFAULT_PRIORITY));
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		if (!hasCreateDate) {
			orders.add(Order.desc(DEFAULT_CREATEDATE));
		}

		setOrders(example, orders);
		return example;

	}

	/**
	 * 
	 * @Title: setSearchFilters
	 * @Description: 设置条件
	 * @param example
	 * @param searchFilters
	 * @return: void
	 */
	@SuppressWarnings({ "incomplete-switch", "unused", "rawtypes", "unchecked" })
	private void setSearchFilters(Example example, List<SearchFilter> searchFilters) {
		Criteria createCriteria = example.createCriteria();
		for (SearchFilter searchFilter : searchFilters) {
			String property = searchFilter.getProperty();
			Object value = searchFilter.getValue();
			// 目前忽略大小写这个功能暂时没有方法去实现
			boolean ignoreCase = searchFilter.getIgnoreCase();
			OperatorEnum operator = searchFilter.getOperator();

			switch (operator) {
			case EQ:
				createCriteria.andEqualTo(property, value);
				break;
			case NE:
				createCriteria.andNotEqualTo(property, value);
				break;
			case GT:
				createCriteria.andGreaterThan(property, value);
				break;
			case GE:
				createCriteria.andGreaterThanOrEqualTo(property, value);
				break;
			case LT:
				createCriteria.andLessThan(property, value);
				break;
			case LE:
				createCriteria.andLessThanOrEqualTo(property, value);
				break;
			case LIKE:
				createCriteria.andLike(property, (String) value);
				break;
			case NOTLIKE:
				createCriteria.andNotLike(property, (String) value);
				break;
			case IN:
				createCriteria.andIn(property, (Iterable) value);
				break;
			case NOTIN:
				createCriteria.andNotIn(property, (Iterable) value);
				break;
			case ISNULL:
				createCriteria.andIsNull(property);
				break;
			case ISNOTNULL:
				createCriteria.andIsNotNull(property);
				break;
			case BT:
				createCriteria.andBetween(property, ((List<Object>) value).get(0), ((List<Object>) value).get(1));
				break;
			case NOTBT:
				createCriteria.andNotBetween(property, ((List<Object>) value).get(0), ((List<Object>) value).get(1));
				break;
			case CONDITION:
				if (value == null) {
					createCriteria.andCondition(property);
				} else {
					createCriteria.andCondition(property, value);
				}
			}
		}
	}

	/**
	 * 
	 * @Title: setOrders
	 * @Description: 设置排序
	 * @param example
	 * @param orders
	 * @return: void
	 */
	private void setOrders(Example example, List<Order> orders) {
		OrderBy ob = null;
		for (Order order : orders) {
			if (ob == null) {
				ob = example.orderBy(order.getProperty());
			} else {
				ob.orderBy(order.getProperty());
			}

			switch (order.getDirection()) {
			case asc:
				ob.asc();
				break;
			case desc:
				ob.desc();
				break;
			default:
				break;
			}
		}
	}

	/**
	 * 
	 * @Title: getSearchFilters
	 * @Description: 将searchFilters...变成list
	 * @param searchFilters
	 * @return
	 * @return: List<SearchFilter>
	 */
	private List<SearchFilter> getSearchFilters(SearchFilter... searchFilters) {
		List<SearchFilter> filters = new ArrayList<SearchFilter>();
		Collections.addAll(filters, searchFilters);
		return filters;

	}

	/**
	 * 
	 * @Title: setCreateDate
	 * @Description: 设置创建日期
	 * @param t
	 * @return
	 * @return: void
	 */
	private void setCreateDate(T t) {
		if (t instanceof BaseEntity) {
			((BaseEntity) t).setCreateDate(new Date());
			((BaseEntity) t).setModifyDate(new Date());
		}
	}

	/**
	 * 
	 * @Title: setModifyDate
	 * @Description: 设置修改时间
	 * @param t
	 * @return: void
	 */
	private void setModifyDate(T t) {
		if (t instanceof BaseEntity) {
			((BaseEntity) t).setModifyDate(new Date());
		}
	}

}
