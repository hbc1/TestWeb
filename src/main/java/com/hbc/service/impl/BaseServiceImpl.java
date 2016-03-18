package com.hbc.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import com.hbc.dao.BaseDao;
import com.hbc.dao.UserDao;
import com.hbc.service.BaseService;
@SuppressWarnings("unchecked")
public class BaseServiceImpl<T> implements BaseService<T> {
	private Class clazz;
	protected BaseDao baseDao;
	@Resource
	protected UserDao userDao;
	
	public BaseServiceImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
	}
	@PostConstruct
	public void initData() throws Exception{
		String clazzName = clazz.getSimpleName();
		String clazzDao = clazzName.substring(0,1).toLowerCase()+clazzName.substring(1)+"Dao";
		Field clazzFiled = this.getClass().getSuperclass().getDeclaredField(clazzDao);
		Field baseFiled = this.getClass().getSuperclass().getDeclaredField("baseDao");
		
		baseFiled.set(this, clazzFiled.get(this));
	}
	
	@Override
	public int save(T t) {
		return baseDao.save(t);
	}

	@Override
	public int deleteByIds(String[] ids) {
		return baseDao.deleteByIds(ids);
	}

	@Override
	public int update(T t) {
		return baseDao.update(t);
	}

	@Override
	public T get(int id) {
		return (T) baseDao.get(id);
	}

	@Override
	public List<T> queryForPage(String keyword, int currentPage, int size) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("keyword", "%"+keyword+"%");
		paramMap.put("start", (currentPage-1)*size);
		paramMap.put("size", size);
		return baseDao.queryForPage(keyword, currentPage, size);
	}

	@Override
	public List<T> query() {
		return baseDao.query();
	}

	@Override
	public int queryCount(String keyword) {
		keyword ="%"+keyword+"%";
		return baseDao.queryCount(keyword);
	}

}
