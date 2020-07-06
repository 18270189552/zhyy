package com.two.zhyy.pojo;

/**
 * 医师记录实体类
 * @author 刘松杰
 * @param <E>
 *
 */
public class Drecord {
	
	
	//逻辑主键
	private Integer drid;
	
	//处方
	private String recipe;
	
	//处理症状
	private String symptom;
	
	//处理类型
	private String types;

	//挂号Id(外键)
	private Reg reg;
	
	public int getDrid() {
		return drid;
	}

	public void setDrid(int drid) {
		this.drid = drid;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public Reg getReg() {
		return reg;
	}

	public void setReg(Reg reg) {
		this.reg = reg;
	}
	
	
	

}
