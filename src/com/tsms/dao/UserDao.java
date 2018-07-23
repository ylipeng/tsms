package com.tsms.dao;

import java.util.Map;

import com.tsms.entity.User;

public interface UserDao {
	

	/**
	 * 登陆验证
	 * @param userName
	 * @return
	 */
	User getLogin(String userName);
	
	/**
	 * 个人信息
	 * @param username
	 * @return
	 */
	Map<String, String> getUserInfoByUsername(String username);
	
	/**
	 * 获得需要修改用户的盐值(salt)
	 * @param username
	 * @return
	 */
	String getSaltByUserName(String username);
	
	/**
	 * 获得需要修改用户的密码
	 * @param username
	 * @return
	 */
	String getPasswordByUserName(String username);
	
	
	/**
	 * 密码修改
	 * @param username
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	boolean updateUserPassword(String username,String newPassword);
	
}
