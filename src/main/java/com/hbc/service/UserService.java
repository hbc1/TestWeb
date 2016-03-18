package com.hbc.service;

import com.hbc.model.User;

public interface UserService extends BaseService<User>{
	public User login(User user);
	public boolean checkUser(String userName);
}
