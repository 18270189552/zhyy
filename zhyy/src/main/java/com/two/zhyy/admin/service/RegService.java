package com.two.zhyy.admin.service;
import java.util.List;

import com.two.zhyy.pojo.Reg;

/**
 * 挂号管理接口
 * @author 汪怀杰
 *
 */
public interface RegService {

	/**
	 * 查询所有挂号
	 * @return
	 */
	List<Reg> findByAll();
	
	/**
	 * 查询单个挂号信息
	 * @param id
	 * @return
	 */
	Reg findByid(int id);
	
	/**
	 * 修改挂号信息
	 * @param r
	 */
	void update(Reg r);
	
	/**
	 * 修改挂号信息
	 * @param r
	 */
	void insertReg(Reg r);
}
