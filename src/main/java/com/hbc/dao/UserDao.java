package com.hbc.dao;

import com.hbc.model.User;

public interface UserDao extends BaseDao<User>{
	public User login(User user);
	public boolean checkUser(String userName);
}
