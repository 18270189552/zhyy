package com.two.zhyy.admin.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 用户表
 * @author 小米
 *
 */
@Entity
@Table
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //用户主键

	@Column
	private String username;  //用户账户

	@Column
	private String password;  //用户密码
	
	@OneToOne
	@JoinColumn(name = "mcid")
	private Medicalcard medicalcard;	//用户医疗卡id（外键）
	
	@OneToOne
	@JoinColumn(name = "ptid")
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
