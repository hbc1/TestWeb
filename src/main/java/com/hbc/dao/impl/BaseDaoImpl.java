package com.hbc.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

import com.hbc.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {
	private Class clazz;
	
	public BaseDaoImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
	}
	
	@Resource
	protected SqlSessionTemplate sqlSession;
	
	@Override
	public int save(T t) {
		return sqlSession.insert(clazz.getName()+".save", t);
	}

	@Override
	public int deleteByIds(String[] ids) {
		return sqlSession.delete(clazz.getName()+".deleteByIds", ids);
	}

	@Override
	public int update(T t) {
		return sqlSession.update(clazz.getName()+".update", t);
	}

	@Override
	public T get(int id) {
		return sqlSession.selectOne(clazz.getName()+".get", id);
	}

	@Override
	public List<T> queryForPage(String keyword, int currentPage, int size) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("keyword", "%"+keyword+"%");
		paramMap.put("start", (currentPage-1)*size);
		paramMap.put("size", size);
		return sqlSession.selectList(clazz.getName()+".queryForPage", paramMap);
	}

	@Override
	public List<T> query() {
		return sqlSession.selectList(clazz.getName()+".query");
	}

	@Override
	public int queryCount(String keyword) {
		keyword ="%"+keyword+"%";
		return sqlSession.selectOne(clazz.getName()+".queryCount",keyword);
	}

}
