package com.aaronazon.springmvc.service;

import com.aaronazon.springmvc.view.UserView;

public interface UserService {
	
	UserView validateUser(UserView user);
	UserView registerUser(UserView user);

}
