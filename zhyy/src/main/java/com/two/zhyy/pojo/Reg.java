package com.two.zhyy.pojo;

import javax.xml.crypto.Data;

/**
 * 挂号表实体类
 * @author 刘松杰
 *
 */
public class Reg {
	
	Integer regid;//挂号id
	
	Data regtime;//挂号时间
	
	String regstate;//挂号状态

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
}
