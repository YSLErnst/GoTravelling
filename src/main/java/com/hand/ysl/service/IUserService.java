package com.hand.ysl.service;

/**
 * 
 * create by Ernst on 2016年12月12日
 */
public interface IUserService {

	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	public String login(String username,String password);
	
}
