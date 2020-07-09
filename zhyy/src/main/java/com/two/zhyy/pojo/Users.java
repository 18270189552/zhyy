package com.two.zhyy.pojo;


/**
 * 用户表
 * @author 小米
 *
 */

public class Users {

	
	private Integer id; //用户主键

	private String username;  //用户账户

	private String password;  //用户密码
	
	private Medicalcard medicalcard;	//用户医疗卡id（外键）
	
	private Userpt userpt;	//权限id（外键）
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Medicalcard getMedicalcard() {
		return medicalcard;
	}

	public void setMedicalcard(Medicalcard medicalcard) {
		this.medicalcard = medicalcard;
	}

	public Userpt getUserpt() {
		return userpt;
	}

	public void setUserpt(Userpt userpt) {
		this.userpt = userpt;
	}
}
