package com.two.zhyy.patient.service;


import java.util.List;

import com.two.zhyy.pojo.Reg;
/**
 * 患者业务逻辑层
 * @author 小米
 *
 */
public interface PatientService {

	//定义获取指定患者病史
	List<Reg> assfind(long idcard);
	
}
