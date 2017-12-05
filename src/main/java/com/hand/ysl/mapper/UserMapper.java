package com.hand.ysl.mapper;

import com.hand.ysl.dto.Role;
import com.hand.ysl.dto.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
	   //根据用户名查询
	   List<User> getByUserName(@Param("username") String username);

	/**
	 * 根据用户名获取该用户的角色
	 * @param username
	 * @return
	 */
	   List<Role> getRolesByUserName(@Param("username") String username);
}