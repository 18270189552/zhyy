package com.two.zhyy.admin.service;

import java.util.List;

import com.two.zhyy.admin.pojo.Doctordt;

public interface DoctordtService {
	
	//查询所有医师信息
	List<Doctordt> findAll();
	
	//查询同一级别的医师
	List<Doctordt> findBydocid(int id);
	
	//通过级别查询医师
	List<Doctordt> findByRank(String rank);
	
	//查询同一科室的医师
	List<Doctordt> findByillid(int id);
	
	//通过科室查询医师
	List<Doctordt> findByName(String name);
}
