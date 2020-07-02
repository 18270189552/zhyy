package com.two.zhyy.pojo;


/**
 * 用户表
 * @author 小米
 *
 */

public class Users {

	
	int id; //用户主键

	char username;  //用户账户

	char password;  //用户密码
				//用户医疗卡id（外键）
				//权限id（外键）
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getUsername() {
		return username;
	}
	public void setUsername(char username) {
		this.username = username;
	}
	public char getPassword() {
		return password;
	}
	public void setPassword(char password) {
		this.password = password;
	}
	
}
