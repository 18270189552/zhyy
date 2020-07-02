package com.two.zhyy.pojo;
/**
 * 排班实体类
 * @author Administrator
 *
 */
public class Working {
	/**
	 * 定义属性
	 */
	private Integer workid;  //排班id
	private String data;  //排班日期
	private Integer number;  //最大诊断人数
	private Doctor doctor;	//医师
	
	
	public Integer getWorkid() {
		return workid;
	}
	public void setWorkid(Integer workid) {
		this.workid = workid;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
	
}
