package com.two.zhyy.pojo;
/**
 * 科室
 * @author Administrator
 *
 */
public class Section {

	//科室id	逻辑主键
	int seid;
	
	//科室名
	String sectionname;
	
	public Section() {
	}

	public int getSeid() {
		return seid;
	}

	public void setSeid(int seid) {
		this.seid = seid;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}

}
