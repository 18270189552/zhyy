package com.two.zhyy.admin.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 科室实体类
 * @author 刘松杰
 *
 */
//需要持久化实体类
@Entity
@Table
public class Section {

	//主键
	@Id
	//主键值自增，使用自动生成的值填充
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer seid;//科室id
	
	//列
	@Column
	String sectionname;//科室名称

	public Integer getSeid() {
		return seid;
	}

	public void setSeid(Integer seid) {
		this.seid = seid;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}
}
