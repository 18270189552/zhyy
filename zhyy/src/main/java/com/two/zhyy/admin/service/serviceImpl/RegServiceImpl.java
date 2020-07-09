package com.two.zhyy.admin.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.zhyy.admin.mapper.RegMapper;
import com.two.zhyy.admin.service.RegService;
import com.two.zhyy.pojo.Reg;
/**
 * 实现挂号的业务逻辑操作
 * @author 汪怀杰
 *
 */
@Service
public class RegServiceImpl implements RegService{

	@Autowired
	RegMapper rm;	
	
	@Override
	public List<Reg> findByAll() {
		return rm.findByAllReg();
	}

	@Override
	public List<Reg> findByid(long id) {
		return rm.findByIdReg(id);
	}

	@Override
	public int delete(int id) {
		 return rm.delete(id);
	}
}
