package com.two.zhyy.admin.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.zhyy.admin.mapper.SchedulingMapper;
import com.two.zhyy.admin.service.SchedulingService;
import com.two.zhyy.pojo.Working;

@Service
public class SchedulingServiceImpl implements SchedulingService{
	@Autowired
	SchedulingMapper sm;
	
	@Override
	public List<Working> findByAll(int id) {
		return sm.findByAll(id);
	}


	@Override
	public List<Working> findById(String name) {
		// TODO Auto-generated method stub
		return sm.findByNamewWorkings(name);
	}


	


}
