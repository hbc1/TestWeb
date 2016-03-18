package com.hbc.dao;

import java.util.List;

public interface BaseDao<T> {
	/**
	 * 添加
	 * @param t
	 */
	public int save(T t);
	
	/**
	 * 根据id删除多个
	 * @param ids  类型String[]，因为前台传的字符串或json
	 * @return 返回影响的记录数
	 */
	public int deleteByIds(String[] ids);
	
	/**
	 * 更新
	 * @param t 
	 * @return 返回影响的记录数
	 */
	public int update(T t);
	
	/**
	 * 根据id查询一个
	 * @param id
	 * @return
	 */
	public T get(int id);
	
	/**
	 * 分页查询
	 * @param keyword  关键字
	 * @param currentPage  当前页
	 * @param size 每页记录
	 * @return
	 */
	public List<T> queryForPage(String keyword,int currentPage,int size);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<T> query();
	
	/**
	 * 查询总记录
	 * @return
	 */
	public int queryCount(String keyword);
	
}
