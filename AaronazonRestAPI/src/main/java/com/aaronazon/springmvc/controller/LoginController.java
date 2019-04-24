package com.aaronazon.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aaronazon.springmvc.model.Login;
import com.aaronazon.springmvc.model.User;
import com.aaronazon.springmvc.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}
	
	@RequestMapping(value="/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(@ModelAttribute("login") Login login) {
		ModelAndView mav = null;
		User user = userService.validateUser(login);
		if(user != null) {
			mav = new ModelAndView("welcome");
			mav.addObject("firstname", user.getFirstName());
		}else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or password is wrong!");
		}
		return mav;
	}

}
