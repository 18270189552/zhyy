package com.two.zhyy.doctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.zhyy.doctor.mapper.DoctorMapper;
import com.two.zhyy.pojo.Userdt;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorMapper DoctorMapper;
	

	@Override
	public List<Userdt> find(String id) {
		
		return DoctorMapper.findAll(id);
	}

}
