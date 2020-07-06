package com.two.zhyy.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.two.zhyy.patient.mapper.PatientMapper;
import com.two.zhyy.pojo.Log;
import com.two.zhyy.pojo.Medicalcard;
import com.two.zhyy.pojo.Reg;
import com.two.zhyy.pojo.Userdt;
import com.two.zhyy.pojo.Users;

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
	//定义事务
	@Autowired
	ApplicationContext cont;
	
	//定义获取指定患者病史
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
	
	


	//定义添加用户信息表的信息
	@Override
	public void insertUsers(Users users) {
		patientMapper.insertUsers(users);
	}

	//定义添加患者表的信息
	@Override
	public int insertUserdt(Userdt userdt) {
		patientMapper.insertUserdt(userdt);
		return userdt.getUdtid();
	}

	//定义添加卡号的信息
	@Override
	public void insertcard(Medicalcard card) {
		patientMapper.insertcard(card);
		//定义用户与卡号进行绑定
		patientMapper.updateusers(card.getMcid(),card.getUsers().getId());
	}
	
	//定义添加患者挂号表信息
	@Override
	public void insertReg(Reg reg) {
		//定义日志对象
		Log log=new Log();
		log.setReg(reg);
		log.setLogtime(reg.getRegtime());
		log.setLogstate(reg.getRegstate());
		log.setLogprice(reg.getDoctordt().getDocid().getRprice());
		PatientServiceImpl ohen=cont.getBean(PatientServiceImpl.class);
		//嵌套调用了另一个方法
		createLog(log);
		patientMapper.insertReg(reg);
	}


	//定义添加日志表（交易时间,交易状态,交易价格,reg:挂号id（外键））
	//事务的传播行为
	//挂起原事务，创建一个独立的新事务，与外部事务回滚不影响它的执行
	@Transactional
	public void createLog(Log log) {
		patientMapper.insert(log);
	}
	
	
}
