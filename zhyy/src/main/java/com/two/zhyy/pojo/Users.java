package com.two.zhyy.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 用户表
 * @author 小米
 *
 */
//持久化实体类
@Entity
public class Users {

	//主键
	@Id
	//使用自动生成的值去填充
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id; //用户主键
	//指定列
	@Column
	char username;  //用户账户
	@Column
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
