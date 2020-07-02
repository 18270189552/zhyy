package com.two.zhyy.pojo;

/**
 * 患者详细表
 * @author 刘松杰
 *
 */
public class Userdt {

	Integer udtid;//患者详细id
	
	String name;//患者姓名
	
	String idcard;//患者身份证号码
	
	String phone;//患者电话
	
	Integer age;//患者年龄
	
	String sex;//患者性别

	public Integer getUdtid() {
		return udtid;
	}

	public void setUdtid(Integer udtid) {
		this.udtid = udtid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
