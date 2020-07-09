package com.two.zhyy.admin.service;

import java.util.List;
import java.util.Map;

import com.two.zhyy.pojo.Working;

public interface SchedulingService {
	
	
	/** 
	 * 查询所有排班信息
	 * @return
	 */
	List<Working> findByAll(int id);
	
	/**
	 * 根据工号查询排班
	 * @param id
	 * @return
	 */
	List<Working> findById(String name);
	
	/**
	 * 删除当前医生的排班信息
	 * @param id
	 */
	String del(int id);
}
