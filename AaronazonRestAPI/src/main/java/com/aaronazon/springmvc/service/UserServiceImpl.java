package com.aaronazon.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaronazon.springmvc.dao.UserDao;
import com.aaronazon.springmvc.model.Login;
import com.aaronazon.springmvc.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{


	@Autowired
	private UserDao userDao;

	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}

	public User registerUser(User user) {
		// will allow you to add new users
		return null;
	}

}
