package com.two.zhyy.pojo;

public class Drecord {
	
	//逻辑主键
	int drid;
	
	//处方
	String recipe;
	
	//处理症状
	String symptom;
	
	//处理类型
	String type;

	//挂号Id(外键)
	
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

	
	

}
