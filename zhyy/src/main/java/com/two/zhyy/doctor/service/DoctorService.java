package com.two.zhyy.doctor.service;

import java.util.List;

import com.two.zhyy.pojo.Doctordt;
import com.two.zhyy.pojo.Drecord;
import com.two.zhyy.pojo.Reg;
import com.two.zhyy.pojo.Userdt;
import com.two.zhyy.pojo.Working;

public interface DoctorService {
	
	
	//查询对应编号医生当天的患者全部信息
	List<Reg> find(String id);
	
	//开处方
	int create(Drecord drecord);
	
	//添加患者的诊断信息和修改挂号状态
	int up(Integer id,Integer drid,String stat);
	
	//修改诊断人数和添加患者信息
	int mo(Working working,Reg reg);

	Userdt findByUserdt(int idcard);
	
}
