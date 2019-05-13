package com.aaronazon.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aaronazon.springmvc.service.UserService;
import com.aaronazon.springmvc.view.UserView;

@Controller
@RequestMapping("user")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<UserView> createUser(@RequestBody UserView userView){
		
		UserView newUser = userService.registerUser(userView);
		return new ResponseEntity<> (newUser, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<UserView> authenicateUser(@PathVariable long id, @RequestBody UserView userView){
		userView = userService.validateUser(userView);
		return new ResponseEntity<> (userView, HttpStatus.OK);
	}
	
}
