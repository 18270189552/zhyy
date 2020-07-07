package com.two.zhyy.doctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.zhyy.doctor.mapper.DoctorMapper;
import com.two.zhyy.pojo.Drecord;
import com.two.zhyy.pojo.Reg;
import com.two.zhyy.pojo.Userdt;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorMapper DoctorMapper;
	

	@Override
	public List<Reg> find(String id) {
		
		return DoctorMapper.findAll(id);
	}


	@Override
	public int create(Drecord drecord) {
		
		return DoctorMapper.save(drecord);
	}


	@Override
	public int up(Integer id,Integer drid,String stat) {
		return DoctorMapper.update(id,drid,stat);
	}






	





	

}
