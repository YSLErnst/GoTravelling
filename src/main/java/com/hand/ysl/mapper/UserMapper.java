package com.hand.ysl.mapper;

import com.hand.ysl.dto.User;

public interface UserMapper {
	   //根据用户名查询
	   public User getByUserName(String username);
}