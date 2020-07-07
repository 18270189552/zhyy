package com.two.zhyy.admin.pojo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 医疗卡
 * @author Administrator
 *
 */
@Entity
@Table
public class Medicalcard {
	
	//医疗卡id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mcid;//逻辑主键
	
	//金额
	@Column
	private BigDecimal money;
	
	//用户id 外键
//	private Users users;
//
//	public Users getUsers() {
//		return users;
//	}
//
//	public void setUsers(Users users) {
//		this.users = users;
//	}

	public Integer getMcid() {
		return mcid;
	}

	public void setMcid(Integer mcid) {
		this.mcid = mcid;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}
}
