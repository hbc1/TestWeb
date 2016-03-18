package com.hbc.dao.impl;

import org.springframework.stereotype.Repository;

import com.hbc.dao.UserDao;
import com.hbc.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	@Override
	public User login(User user) {
		return sqlSession.selectOne(User.class.getName() + ".login",user);
	}

	@Override
	public boolean checkUser(String userName) {
		Object userLogin = sqlSession.selectOne(User.class.getName()+".checkUser", userName);
		return userLogin == null? false : true;
	}

}
