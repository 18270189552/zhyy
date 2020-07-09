package com.two.zhyy.admin.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 权限表
 * @author 小米
 *
 */
@Entity
@Table
public class Userpt {

	//主键
	@Id
	//自增
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ptid;  //权限id
	
	@Column
	private String prole;  //患者 1

	public Integer getPtid() {
		return ptid;
	}

	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	public String getProle() {
		return prole;
	}

	public void setProle(String prole) {
		this.prole = prole;
	}
}
