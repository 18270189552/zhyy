package com.two.zhyy.patient.service;


import java.util.List;
import java.util.Map;

import com.two.zhyy.patient.exception.NoMoneyException;
import com.two.zhyy.patient.exception.OverLoadException;
import com.two.zhyy.pojo.Doctordt;
import com.two.zhyy.pojo.Illness;
import com.two.zhyy.pojo.Log;
import com.two.zhyy.pojo.Medicalcard;
import com.two.zhyy.pojo.Reg;
import com.two.zhyy.pojo.Section;
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
	void insertReg(Reg reg) throws NoMoneyException, OverLoadException;
	
	//--------------------------------------------------
	//显示一级科室信息
	List<Section> sectionAll();
		
	//显示二级科室信息
	List<Illness> illnesseId(String seid);
		
	//显示科室下的医师
	List<Doctordt> doctorId(String illid);
	
	//显示科室下14天值班医师
	Map<String, List<Doctordt>> doctorTime(String illid);
		
	//显示指定科室14天的排班
	//Map<String, Object> doctorDate(String illid);
		
	//显示指定医师的排班
	Map<String, Object> doctorWorking(String ddtid);
	
	//显示打卡成功的患者
	List<Object> clock(Reg reg) throws NoMoneyException;
	
}
