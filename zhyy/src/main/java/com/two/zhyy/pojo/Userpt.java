package com.two.zhyy.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//权限表
//持久化实体类
@Entity
public class Userpt {

	//权限表id
	//主键id
	@Id
	//自动填充
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int ptid;  //权限id
	//自动列
	@Column
	int patient;  //患者 1
	@Column
	int doctor;  //医师 2
	@Column
	int admin;  //管理员 3
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
