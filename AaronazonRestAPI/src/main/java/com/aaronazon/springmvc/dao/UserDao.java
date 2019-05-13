package com.aaronazon.springmvc.dao;

import com.aaronazon.springmvc.entity.User;

public interface UserDao {
	
	User validateUser(User user);
	User registerUser(User user);

}
