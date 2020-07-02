package com.two.zhyy.pojo;


/**
 * 权限表
 * @author 小米
 *
 */

public class Userpt {


	private Integer ptid;  //权限id
	
	private Integer patient;  //患者 1
	
	private Integer doctor;  //医师 2
	
	private Integer admin;  //管理员 3
	public int getPtid() {
		return ptid;
	}
	public void setPtid(int ptid) {
		this.ptid = ptid;
	}
	public int getPatient() {
		return patient;
	}
	public void setPatient(int patient) {
		this.patient = patient;
	}
	public int getDoctor() {
		return doctor;
	}
	public void setDoctor(int doctor) {
		this.doctor = doctor;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	
}
