package com.two.zhyy.pojo;

import java.math.BigDecimal;

/**
 * 医疗卡
 * @author Administrator
 *
 */
public class Medicalcard {
	
	//医疗卡id
	private Integer mcid;			//逻辑主键
	
	//金额
	private BigDecimal money;
	
	//卡号
	private String mcard;
	
	//用户id 外键
	private Users users;
	
	public String getMcard() {
		return mcard;
	}

	public void setMcard(String mcard) {
		this.mcard = mcard;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Medicalcard() {
	}
	
	public Users getId() {
		return users;
	}

	public void setId(Users id) {
		this.users = id;
	}

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
