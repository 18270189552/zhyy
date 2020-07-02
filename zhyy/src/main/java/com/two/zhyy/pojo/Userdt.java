package com.two.zhyy.pojo;

/**
 * 挂号人详情表
 * @author 小米
 *
 */
public class Userdt {
	
	private Integer udtid;  //主键
	
	private String name;  //挂号人姓名
	
	private String  ldcard;  //挂号人身份证
	
	private String  phone;  //挂号人电话
	
	private int age;  //挂号人年龄
	
	private String  sex;  //挂号人性别
	
	private Users users;  //用户（外键）

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

	public String getLdcard() {
		return ldcard;
	}

	public void setLdcard(String ldcard) {
		this.ldcard = ldcard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
}
