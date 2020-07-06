package com.two.zhyy.pojo;

import java.math.BigDecimal;

/**
 * 医师实体类
 * @author 刘松杰
 *
 */
public class Doctor {

	private Integer docid;//医师id
	
	private String rank;//医师级别
	
	private BigDecimal rprice;//挂号价格
	
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

	public BigDecimal getRprice() {
		return rprice;
	}

	public void setRprice(BigDecimal rprice) {
		this.rprice = rprice;
	}

	
	
}
