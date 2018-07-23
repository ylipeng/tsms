package com.tsms.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.tsms.dao.UserDao;
import com.tsms.entity.User;
import com.tsms.util.DBUtil;

public class UserDaoImpl implements UserDao {

	private DBUtil db = DBUtil.getInstance();
	private String sql = "";
	private List<Map<String, String>> list ;
	private Map<String, String> result;

	/**
	 * 登陆验证
	 */
	@Override
	public User getLogin(String userName) {
		sql = "select * from tb_user where username=?";
		list = db.query(sql, userName);
		User user = new User();
		if (list.size() <= 0) {
			user = null;
		} else {
			try {
				BeanUtils.populate(user, list.get(0));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	/**
	 * 个人信息展示
	 */
	@Override
	public Map<String, String> getUserInfoByUsername(String username) {
		sql = "select u.taxerId,u.permissionId,u.state,ta.taxerCode,ta.taxerName,ta.birthday,ta.mobile,ta.address,ta.sex,ta.email,ta.organId,ta.state st,ta.mgr,ta.admin "
				+ "from tb_user u join tb_taxer ta on u.taxerId=ta.id where username=?";
		list = db.query(sql, username);
		result = list.get(0);
		return result;
	}

	/**
	 * 获得需要修改用户的盐值(salt)
	 * @param username
	 * @return
	 */
	@Override
	public String getSaltByUserName(String username) {
		sql = "select salt from tb_user where username=?";
		list = db.query(sql, username);
		result = list.get(0);
		if(result.size()<=0){
			return null;
		}
		String salt = result.get("salt");
		return salt;
	}
	
	/**
	 * 获得需要修改用户的原始密码
	 * @param username
	 * @return
	 */
	@Override
	public String getPasswordByUserName(String username) {
		sql = "select password from tb_user where username=?";
		list = db.query(sql, username);
		result = list.get(0);
		if(result.size()<=0){
			return null;
		}
		String password = result.get("password");
		return password;
	}

	/**
	 * 密码修改
	 * @param username
	 * @param newPassword
	 * @return
	 */
	@Override
	public boolean updateUserPassword(String username, String newPassword) {
		sql = "update tb_user set password=? where username=? ";
		Object [] params = {newPassword,username};
		boolean b = db.update(sql, params);
		return b;
	}

}


