package com.two.zhyy.patient.service;


import java.util.List;

import com.two.zhyy.pojo.Log;
import com.two.zhyy.pojo.Reg;
/**
 * 患者业务逻辑层
 * @author 小米
 *
 */
public interface PatientService {

	//定义获取指定患者病史
	List<Reg> assfind(long idcard);
	
	//修改reg表中的regstate中的状态 0(取消预约) 1(预约成功) 2(签到成功)
	void update(Reg reg);
	
	//定义添加日志表（交易时间,交易状态,交易价格,reg:挂号id（外键））
	Log createLog(Log log);
	
}
