package com.two.zhyy.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.zhyy.patient.mapper.PatientMapper;
import com.two.zhyy.pojo.Reg;

/**
 * 业务逻辑的实现类
 * @author 小米
 *的撒发
 */
@Service
public class PatientServiceImpl implements PatientService{

	//获取与数据库交互的对象
	//自动注入
	@Autowired
	PatientMapper patientMapper;
	@Override
	public List<Reg> assfind(long idcard) {
		List<Reg> reglist=patientMapper.load(idcard);
		return reglist;
	}

	
	
}
