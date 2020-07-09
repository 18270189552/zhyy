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
	List<Reg> findByid(long id);
	
	
	/**
	 * 删除挂号信息
	 * @param id
	 */
	int delete(int id);
}
