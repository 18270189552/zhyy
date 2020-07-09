package com.two.zhyy.admin.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.zhyy.admin.mapper.IllnessMapper;
import com.two.zhyy.admin.pojo.Illness;
import com.two.zhyy.admin.service.IllnessService;

@Service
public class IllnessServiceImpl implements IllnessService{

	//自动注入
	@Autowired
	IllnessMapper illnessMapper;
	
	//查询所有科室信息
	@Override
	public List<Illness> findAll() {
		return illnessMapper.findAll();
	}

	//查询单个科室信息
	@Override
	public Illness findById(int id) {
		return illnessMapper.findById(id);
	}

	//查询同一大科下的所有科室信息
	@Override
	public List<Illness> findBySeid(int id) {
		return illnessMapper.findBySeid(id);
	}

	@Override
	public List<Illness> findName(String name) {
		return illnessMapper.findName(name);
	}

}
