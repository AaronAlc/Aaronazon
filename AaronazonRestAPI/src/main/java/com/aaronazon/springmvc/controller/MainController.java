package com.aaronazon.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {

	//home page
	@RequestMapping(method = RequestMethod.GET)
	public String getHomePage() {
		return "home";
	}

	//item management page
	@RequestMapping(value="/itemmanagement", method = RequestMethod.GET)
	public String getIndexPage() {
		return "ItemManagement";
	}
	

}
