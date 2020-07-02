package com.two.zhyy.pojo;

/**
 * 子科室实体类
 * @author 刘松杰
 *
 */
public class Illness {

	Integer illid;//子科室id
	
	String illnessname;//名称

	public Integer getIllid() {
		return illid;
	}

	public void setIllid(Integer illid) {
		this.illid = illid;
	}

	public String getIllnessname() {
		return illnessname;
	}

	public void setIllnessname(String illnessname) {
		this.illnessname = illnessname;
	}
}
