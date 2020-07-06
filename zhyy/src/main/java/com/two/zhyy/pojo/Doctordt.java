package com.two.zhyy.pojo;

/**
 * 医师详细实体类
 * @author 刘松杰
 *
 */
public class Doctordt {
	
	

	private Integer ddtid;//医师详细id
	
	private String dintroduce;//医师介绍
	
	private String dname;//医师姓名
	
	private String dsex;//医师性别

    Integer docid;//医生id（外键）
    
    private String illid;//科室
    
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

	public Integer getDocid() {
		return docid;
	}

	public void setDocid(Integer docid) {
		this.docid = docid;
	}

	public String getIllid() {
		return illid;
	}

	public void setIllid(String illid) {
		this.illid = illid;
	}

	

	
	
}
