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
		// TODO Auto-generated method stub
		return rm.findByAllReg();
	}

	@Override
	public Reg findByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Reg r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertReg(Reg r) {
		// TODO Auto-generated method stub
		
	}

}
