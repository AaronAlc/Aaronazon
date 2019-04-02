package com.aaronazon.springmvc.service;

import org.springframework.stereotype.Service;

import com.aaronazon.springmvc.model.Login;
import com.aaronazon.springmvc.model.User;

@Service()
public class UserServiceImpl implements UserService{

	/**
	 * @see com.aaronazon.springmvc.service.UserService#validateUser(com.aaronazon.springmvc.model.Login)
	 */
	public User validateUser(Login login) {
		//TODO Will need to make null safe when connecting to database
		if(login.getUserName().equals("aaron") && login.getPassword().equals("test")) {
			User u1 = new User("Aaron", "test");
			u1.setFirstName("Aaron");
			return u1;
		}
		return null;
	}

	public User registerUser(User user) {
		// TODO Auto-generated method stub
		// will allow you to add new users
		return null;
	}

}
