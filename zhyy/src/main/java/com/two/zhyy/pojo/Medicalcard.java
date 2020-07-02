package com.two.zhyy.pojo;

import java.math.BigDecimal;

/**
 * 医疗卡
 * @author Administrator
 *
 */
public class Medicalcard {
	
	//医疗卡id
	int mcid;			//逻辑主键
	
	//金额
	BigDecimal money;
	
	//用户id 外键
	
	
	public Medicalcard() {
	}

	
	public int getMcid() {
		return mcid;
	}

	public void setMcid(int mcid) {
		this.mcid = mcid;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

}
