package com.two.zhyy.admin.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 医师详细实体类
 * @author 刘松杰
 *
 */
@Entity
@Table
public class Doctordt {
	
	//主键
	@Id
	//自增
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ddtid;//医师详细id
	
	@Column
	private String dintroduce;//医师介绍
	
	@Column
	private String dname;//医师姓名
	
	@Column
	private String dsex;//医师性别

	@OneToOne
	@JoinColumn(name = "docid")
    private Doctor doctor;//医生id（外键）
    
	@OneToOne
	@JoinColumn(name = "illid")
    private Illness illness;//科室id（外键）

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

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Illness getIllness() {
		return illness;
	}

	public void setIllness(Illness illness) {
		this.illness = illness;
	}
}
