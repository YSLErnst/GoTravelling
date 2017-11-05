package com.hand.ysl.controller;

import java.net.InetAddress;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hand.ysl.service.IUserService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("userController")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	//定义一个全局的记录器，通过LoggerFactory获取
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

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

	@RequestMapping(value = "/checkIp", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String checkIp() {
		InetAddress ia=null;
		String localname = "";
		String localip = "";
		try {
			ia=ia.getLocalHost();

			localname = ia.getHostName();
			localip = ia.getHostAddress();
			System.out.println("本机名称是："+ localname);
			System.out.println("本机的ip是 ："+localip);
			logger.info("--------------------本机名称是：" + localname + ",本机的ip是 ：" + localip + "-------------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "本机名称是："+localname+",本机的ip是:"+localip;
	}
}
