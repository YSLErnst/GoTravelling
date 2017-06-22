package com.hand.ysl.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hand.ysl.service.IUserService;

/**
 * 
 * 
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String getByController(String id) {
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody Map map) {
		String username = (String) map.get("username");
		String pwd = (String) map.get("password");
		String result = userService.login(username, pwd);
		if(result.equals("OK")){
			return "success";
		}else {
			return "failure";
		}
		
	}
}
