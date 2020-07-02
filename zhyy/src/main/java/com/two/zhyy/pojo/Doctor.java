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
	
	private Doctordt doctordt;	//医生详细id（外键）
	
	private Illness illness;	//子科室id（外键）
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

	public Doctordt getDoctordt() {
		return doctordt;
	}

	public void setDoctordt(Doctordt doctordt) {
		this.doctordt = doctordt;
	}

	public Illness getIllness() {
		return illness;
	}

	public void setIllness(Illness illness) {
		this.illness = illness;
	}
	
}
