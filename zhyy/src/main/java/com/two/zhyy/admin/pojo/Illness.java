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
 * 子科室实体类
 * @author 刘松杰
 *
 */
//需要持久化实体类
@Entity
@Table
public class Illness {

	//主键
	@Id
	//主键值自增，使用自动生成的值填充
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer illid;//子科室id
	
	//列
	@Column
	String illnessname;//名称
	
	@OneToOne
	//自定义外键名称
	@JoinColumn(name = "seid")
	Section section;//科室外键

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

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
}
