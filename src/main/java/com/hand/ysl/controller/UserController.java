package com.hand.ysl.controller;

import com.hand.ysl.service.HelloService;
import com.hand.ysl.service.impl.MyUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.net.InetAddress;

@Controller("userController")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private MyUserDetailService userService;

	@Autowired
	private HelloService helloService;

	@Value("#{configProperties['elasticsearchIp']}")
	private String esIp;

	@Value("#{configProperties['elasticsearchPort']}")
	private String esPort;

	@Value("#{configProperties['elasticsearchClusterName']}")
	private String esCluster;

	@Autowired
	private AmqpTemplate amqpTemplate;



	//定义一个全局的记录器，通过LoggerFactory获取
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String getByController(String id) {
		return "index";
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

	@RequestMapping(value = "/hello", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String hello() {
		try {
			amqpTemplate.convertAndSend("test-mq-exchange","test_queue_key","aaaa12321");
		}catch (Exception e){
			logger.error(e.toString());
		}
		logger.info("es的ip:"+esIp+",es的端口:"+esPort+",es的集群名:"+esCluster);
		return helloService.sayHello("jack");
	}

	@RequestMapping(value = "/bye", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String bye() {
		return helloService.sayBye("tom");
	}


}
