package com.two.zhyy.pojo;

/**
 * 医师详细实体类
 * @author 刘松杰
 *
 */
public class Doctordt {

	Integer ddtid;//医师详细id
	
	String dintroduce;//医师介绍
	
	String dname;//医师姓名
	
	String dsex;//医师性别

	public Integer getDdtid() {
		return ddtid;
	}

	public void setDdtid(Integer ddtid) {
		this.ddtid = ddtid;
	}

	public String getDintroduce() {
		return dintroduce;
	}

	public void setDintroduce(String dintroduce) {
		this.dintroduce = dintroduce;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDsex() {
		return dsex;
	}

	public void setDsex(String dsex) {
		this.dsex = dsex;
	}
}
