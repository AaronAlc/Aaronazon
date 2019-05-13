package com.aaronazon.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaronazon.springmvc.dao.UserDao;
import com.aaronazon.springmvc.entity.User;
import com.aaronazon.springmvc.view.UserView;

@Service
@Transactional
public class UserServiceImpl implements UserService{


	@Autowired
	private UserDao userDao;

	public UserView registerUser(UserView userView) {
		User user = convertUserViewToUser(userView);
		user = userDao.registerUser(user);

		return convertUserToUserView(user);
	}

	@Override
	public UserView validateUser(UserView userView) {
		User user = convertUserViewToUser(userView);
		user = userDao.validateUser(user);
		userView = convertUserToUserView(user);
		return userView;
	}

	private User convertUserViewToUser(UserView userView) {
		User user = new User();
		user.setId(userView.getId());
		user.setUserName(userView.getUserName());
		user.setPassword(userView.getPassword());
		user.setFirstName(userView.getFirstName());
		user.setLastName(userView.getLastName());
		user.setPhone(userView.getPhone());
		user.setEmail(userView.getEmail());
		return user;
	}
	
	private UserView convertUserToUserView(User user) {
		UserView userView = new UserView();
		userView.setId(user.getId());
		userView.setUserName(user.getUserName());
		userView.setPassword(user.getPassword());
		userView.setFirstName(user.getFirstName());
		userView.setLastName(user.getLastName());
		userView.setPhone(user.getPhone());
		userView.setEmail(user.getEmail());
		return userView;
	}
	
}
