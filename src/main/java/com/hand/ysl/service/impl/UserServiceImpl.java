package com.hand.ysl.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.hand.ysl.dto.User;
import com.hand.ysl.mapper.UserMapper;
import com.hand.ysl.service.IUserService;

import java.util.List;


/**
 * 
 * create by Ernst on 2016年12月12日
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


	@Override
	public String login(String username, String password) {
		List<User> users = userMapper.getByUserName(username);
		if(users!=null && users.size()>0){
			logger.info(users.toString());
			return "OK";
		}
		return "NO";
	}


}
