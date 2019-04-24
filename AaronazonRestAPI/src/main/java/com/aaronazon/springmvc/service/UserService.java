package com.aaronazon.springmvc.service;

import com.aaronazon.springmvc.model.Login;
import com.aaronazon.springmvc.model.User;

public interface UserService {
	
	User validateUser(Login login);
	User registerUser(User user);

}
