package com.two.zhyy.pojo;

/**
 * 子科室实体类
 * @author 刘松杰
 *
 */
public class Illness {

	private Integer illid;//子科室id
	
	private String illnessname;//名称
	
	private Section section;	//科室外键
	

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

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
