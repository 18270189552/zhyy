package com.two.zhyy.doctor.service;

import java.util.List;

import com.two.zhyy.pojo.Drecord;
import com.two.zhyy.pojo.Reg;

public interface DoctorService {
	
	
	List<Reg> find(String id);
	
	int create(Drecord drecord);
	
	int up(Integer id,Integer drid,String stat);
	
}
