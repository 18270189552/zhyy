package com.two.zhyy.admin.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 医师实体类
 * @author 刘松杰
 *
 */
@Entity
@Table
public class Doctor {
	
	//主键
	@Id
	//主键值自增
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer docid;//医师id
	
	@Column
	private String rank;//医师级别
	
	@Column
	private Double rprice;//挂号价格

	public Integer getDocid() {
		return docid;
	}

	public void setDocid(Integer docid) {
		this.docid = docid;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Double getRprice() {
		return rprice;
	}

	public void setRprice(Double rprice) {
		this.rprice = rprice;
	}
}
