package com.hand.ysl.controller;

import com.hand.ysl.dto.TokenTransfer;
import com.hand.ysl.service.HelloService;
import com.hand.ysl.service.impl.MyUserDetailService;
import com.hand.ysl.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@Qualifier("authenticationManager")
	private AuthenticationManager authManager;

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
		logger.info("es的ip:"+esIp+",es的端口:"+esPort+",es的集群名:"+esCluster);
		return helloService.sayHello("jack");
	}

	@RequestMapping(value = "/bye", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String bye() {
		return helloService.sayBye("tom");
	}


	@RequestMapping(value = "/loginWithToken", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public TokenTransfer authenticate(@RequestParam String username, @RequestParam String password) {
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(username, password);
		Authentication authentication = this.authManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

      /*
       * Reload user as password of authentication principal will be null after authorization and
       * password is needed for token generation
       */
		UserDetails userDetails = this.userService.loadUserByUsername(username);
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("token", new TokenTransfer(TokenUtils.createToken(userDetails)));

		return new TokenTransfer(TokenUtil.createToken(userDetails));
//        return JsonUtil.getJsonStr(map);
	}

}
