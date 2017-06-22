package com.hand.ysl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.ysl.dto.User;
import com.hand.ysl.mapper.UserMapper;
import com.hand.ysl.service.IUserService;


/**
 * 
 * create by Ernst on 2016年12月12日
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public String login(String username, String password) {
		User user = userMapper.getByUserName(username);
		if(user!=null){
			return "OK";
		}
		return "NO";
	}


}
