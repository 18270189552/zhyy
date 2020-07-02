package com.two.zhyy.pojo;

import javax.xml.crypto.Data;

public class Log {
	
	//逻辑主键
	int logid;
	
	//交易时间
	Data logtime;
	
	//交易状态
	String  logstate;
	
	//交易价格
	Boolean logprice;

	//挂号id（外键）
	
	
	public int getLogid() {
		return logid;
	}

	public void setLogid(int logid) {
		this.logid = logid;
	}

	public Data getLogtime() {
		return logtime;
	}

	public void setLogtime(Data logtime) {
		this.logtime = logtime;
	}

	public String getLogstate() {
		return logstate;
	}

	public void setLogstate(String logstate) {
		this.logstate = logstate;
	}

	public Boolean getLogprice() {
		return logprice;
	}

	public void setLogprice(Boolean logprice) {
		this.logprice = logprice;
	}
	
	
	
	

}
