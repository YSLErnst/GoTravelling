package com.hand.ysl.mapper;

import com.hand.ysl.dto.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	   //根据用户名查询
	   User getByUserName(@Param("username") String username);
}