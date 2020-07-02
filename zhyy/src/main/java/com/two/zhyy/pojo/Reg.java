package com.two.zhyy.pojo;

import javax.xml.crypto.Data;

/**
 * 挂号
 * @author 刘松杰
 *
 */
public class Reg {
	
	//逻辑主键
	int regid;
	
	//挂号时间
	Data regtime;
	
	//挂号状态
	String regstate;
	
	//日志id(外键)
	//用户id(外键)
	//医生id(外键)
	//记录id(外键)

	public int getRegid() {
		return regid;
	}

	public void setRegid(int regid) {
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
