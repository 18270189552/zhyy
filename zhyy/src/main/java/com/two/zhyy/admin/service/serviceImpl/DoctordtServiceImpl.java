package com.two.zhyy.admin.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.zhyy.admin.mapper.DoctordtMapper;
import com.two.zhyy.admin.pojo.Doctordt;
import com.two.zhyy.admin.service.DoctordtService;

@Service
public class DoctordtServiceImpl implements DoctordtService{

	//自动注入
	@Autowired
	DoctordtMapper doctordt;
	
	//查询所有医师信息
	@Override
	public List<Doctordt> findAll() {
		return doctordt.findAll();
	}

	//查询同一级别的医师
	@Override
	public List<Doctordt> findBydocid(int id) {
		return doctordt.findBydocid(id);
	}

	//查询同一科室的医师
	@Override
	public List<Doctordt> findByillid(int id) {
		return doctordt.findByillid(id);
	}

}
