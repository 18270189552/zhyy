package com.two.zhyy.patient.service;


import java.util.List;

import com.two.zhyy.pojo.Log;
import com.two.zhyy.pojo.Medicalcard;
import com.two.zhyy.pojo.Reg;
import com.two.zhyy.pojo.Userdt;
import com.two.zhyy.pojo.Users;
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
	void createLog(Log log);
	
	//定义添加用户信息表的信息
	void insertUsers(Users users);
	
	//定义添加患者表的信息
	int insertUserdt(Userdt userdt);
	
	//定义添加卡号的信息
	void insertcard(Medicalcard card);
	
	//定义添加患者挂号表信息
	void insertReg(Reg reg);
}
