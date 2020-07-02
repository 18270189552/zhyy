package com.two.zhyy.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 挂号人详情表
 * @author 小米
 *
 */

public class Userdt {
	
	int udtid;  //主键
	
	char name;  //挂号人姓名
	
	char ldcard;  //挂号人身份证
	
	char phone;  //挂号人电话
	
	int age;  //挂号人年龄
	
	char sex;  //挂号人性别
	  			//用户表id（外键）
	public int getUdtid() {
		return udtid;
	}
	public void setUdtid(int udtid) {
		this.udtid = udtid;
	}
	public char getName() {
		return name;
	}
	public void setName(char name) {
		this.name = name;
	}
	public char getLdcard() {
		return ldcard;
	}
	public void setLdcard(char ldcard) {
		this.ldcard = ldcard;
	}
	public char getPhone() {
		return phone;
	}
	public void setPhone(char phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
}
