package com.two.zhyy.admin.service;

import java.util.List;

import com.two.zhyy.admin.pojo.Illness;

public interface IllnessService {

	//查询所有科室
	List<Illness> findAll();
	
	//查询单个科室信息
	Illness findById(int id);
	
	//查询同一大科下的所有科室信息
	List<Illness> findBySeid(int id);
}
