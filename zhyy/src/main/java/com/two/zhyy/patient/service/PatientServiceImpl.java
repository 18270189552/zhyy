package com.two.zhyy.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.zhyy.patient.mapper.PatientMapper;
import com.two.zhyy.pojo.Log;
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
	
	//修改reg表中的regstate中的状态 0(取消预约) 1(预约成功) 2(签到成功)
	@Override
	public void update(Reg reg) {
		// TODO Auto-generated method stub
		patientMapper.update(reg);
	}

	////定义添加日志表（交易时间,交易状态,交易价格,reg:挂号id（外键））
	@Override
	public Log createLog(Log log) {
		patientMapper.insert(log);
		return null;
	}

	
	
}
