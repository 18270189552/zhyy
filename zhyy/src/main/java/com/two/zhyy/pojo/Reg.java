package com.two.zhyy.pojo;

import javax.xml.crypto.Data;

/**
 * 挂号
 * @author 刘松杰
 *
 */
public class Reg {
	
	//逻辑主键
	private Integer regid;
	
	//挂号时间
	private Data regtime;
	
	//挂号状态
	private String regstate;
	
	private Log log;//交易日志（外键）
	
	private Doctordt doctordt; //医师
	
	private Drecord drecord;//医师记录（外键）
	
	private Userdt udt;
	

	public Userdt getUdt() {
		return udt;
	}

	public void setUdt(Userdt udt) {
		this.udt = udt;
	}

	public Integer getRegid() {
		return regid;
	}

	public void setRegid(Integer regid) {
		this.regid = regid;
	}

	public Data getRegtime() {
		return regtime;
	}

	public void setRegtime(Data regtime) {
		this.regtime = regtime;
	}

	public String getRegstate() {
		return regstate;
	}

	public void setRegstate(String regstate) {
		this.regstate = regstate;
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public Doctordt getDoctordt() {
		return doctordt;
	}

	public void setDoctordt(Doctordt doctordt) {
		this.doctordt = doctordt;
	}

	public Drecord getDrecord() {
		return drecord;
	}

	public void setDrecord(Drecord drecord) {
		this.drecord = drecord;
	}
}
