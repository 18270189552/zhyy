package com.two.zhyy.pojo;

/**
 * 医师实体类
 * @author 刘松杰
 *
 */
public class Doctor {

	private Integer docid;//医师id
	
	private String rank;//医师级别
	
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
