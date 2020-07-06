package com.two.zhyy.pojo;

import java.math.BigDecimal;

/**
 * 交易日志实体类
 * @author 刘松杰
 *
 */
public class Log {
	
	//逻辑主键
	private Integer logid;
	
	//交易时间
	private String logtime;
	
	//交易状态
	private String  logstate;
	
	//交易价格
	private BigDecimal logprice;

	//挂号id（外键）
	private Reg reg;

	public Integer getLogid() {
		return logid;
	}

	public void setLogid(Integer logid) {
		this.logid = logid;
	}

	public String getLogtime() {
		return logtime;
	}

	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}

	public String getLogstate() {
		return logstate;
	}

	public void setLogstate(String logstate) {
		this.logstate = logstate;
	}

	public BigDecimal getLogprice() {
		return logprice;
	}

	public void setLogprice(BigDecimal logprice) {
		this.logprice = logprice;
	}

	public Reg getReg() {
		return reg;
	}

	public void setReg(Reg reg) {
		this.reg = reg;
	}
	

}
