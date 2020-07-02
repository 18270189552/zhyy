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
	
	//用户id 外键
	private Users users;
	
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
