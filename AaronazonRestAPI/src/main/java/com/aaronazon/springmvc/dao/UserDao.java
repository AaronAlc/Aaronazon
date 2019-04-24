package com.aaronazon.springmvc.dao;

import com.aaronazon.springmvc.model.Login;
import com.aaronazon.springmvc.model.User;

public interface UserDao {
	
	User validateUser(Login login);
	User registerUser(User user);

}
