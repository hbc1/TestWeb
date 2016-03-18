package com.hbc.service.impl;

import org.springframework.stereotype.Service;

import com.hbc.model.User;
import com.hbc.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public boolean checkUser(String userName) {
		return userDao.checkUser(userName);
	}

}
