package com.two.zhyy.patient.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.MediaSize.Other;

import org.hibernate.result.NoMoreReturnsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.two.zhyy.doctor.mapper.DoctorMapper;
import com.two.zhyy.patient.exception.NoMoneyException;
import com.two.zhyy.patient.exception.OverLoadException;
import com.two.zhyy.patient.mapper.PatientMapper;
import com.two.zhyy.pojo.Doctor;
import com.two.zhyy.pojo.Doctordt;
import com.two.zhyy.pojo.Illness;
import com.two.zhyy.pojo.Log;
import com.two.zhyy.pojo.Medicalcard;
import com.two.zhyy.pojo.Reg;
import com.two.zhyy.pojo.Section;
import com.two.zhyy.pojo.Userdt;
import com.two.zhyy.pojo.Users;
import com.two.zhyy.pojo.Working;

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
	
	//医师
	@Autowired
	DoctorMapper doctorMapper;
	
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
	//开启事务
	@Transactional(rollbackFor = {NoMoneyException.class},isolation = Isolation.SERIALIZABLE)
	@Override
	public void insertReg(Reg reg) throws NoMoneyException, OverLoadException {
		List<Reg> findAll = doctorMapper.findAll(reg.getDoctordt().getDdtid().toString(),reg.getRegtime());
		
		System.out.println(reg.getRegtime());
		//获取时间
		String str=reg.getRegtime().substring(reg.getRegtime().indexOf(" ")+1, reg.getRegtime().indexOf(":"));
		int num = Integer.parseInt(str);
		//获取当前系统时间
		SimpleDateFormat df=new SimpleDateFormat("dd");
		String date=df.format(new Date());
		//获取日期
		Date da=null;
		String strs=null;
		try {
			SimpleDateFormat df1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			da = df1.parse(reg.getRegtime());
			strs=df.format(da);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//判断当天日期
		if(date.equals(strs)) {
			if(num<8 || num>10 && num<=14 || num>16) {
				throw new OverLoadException("当天日期：");
			}
		}else {
			if(num<8||num>12&&num<=14||num>18) {
				throw new OverLoadException("其他日期：");
			}
		}
		//判断人数是否已经满了
		if(findAll.size()>=patientMapper.DoctorWorking(reg.getDoctordt().getDdtid().toString()).getNumber()) {
			throw new OverLoadException();
		}
		
		
		patientMapper.insertReg(reg);
		//获取医师信息对象
		Doctordt doctordt=patientMapper.selectDoct(reg.getDoctordt().getDdtid());
		//获取患者与用户对象
		Userdt userdt=patientMapper.userdtload(reg.getUserdt().getUdtid());
		//定义日志对象
		Log log=new Log();
		log.setUserdt(userdt);
		log.setLogtime(reg.getRegtime());
		log.setLogstate(reg.getRegstate());
		log.setLogprice(doctordt.getDocid().getRprice());
		PatientServiceImpl ohen=cont.getBean(PatientServiceImpl.class);
		//嵌套调用了另一个方法
		ohen.createLog(log);
		//患者表的日志互相对应
		patientMapper.updaMed(log.getLogid(), reg.getRegid());
		int from=userdt.getUsers().getMedicalcard().getMcid();
		BigDecimal money=doctordt.getDocid().getRprice();
		//获取卡号的余额
		BigDecimal bigDecimal=patientMapper.selectcards(from);
		//判断卡号余额是否充足
		if(bigDecimal.subtract(money).doubleValue()<0) {
			throw new NoMoneyException(from, money);
		}
		//对应的卡号余额进行减少
		patientMapper.updatecard(from, money.negate());
	}


	private void substringBefore(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	//定义添加日志表（交易时间,交易状态,交易价格,reg:挂号id（外键））
	//事务的传播行为
	//挂起原事务，创建一个独立的新事务，与外部事务回滚不影响它的执行
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void createLog(Log log) {
		patientMapper.insert(log);
	}
	
	//-------------------------------------------------------------
	@Override
	public List<Section> sectionAll() {
		return patientMapper.sectionAll();
	}

	@Override
	public List<Illness> illnesseId(String seid) {
		return patientMapper.illnessId(seid);
	}

	@Override
	public List<Doctordt> doctorId(String illid) {
		return patientMapper.DoctorId(illid);
	}


	@Override
	public Map<String, Object> doctorWorking(String ddtid) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//显示当前星期几
		SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
		Working workings = null;
		Map<String, Object> map = new HashMap<>();
			Date date;
			try {
				date = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
			long l = date.getTime();
			for(int i = 0; i < 14 ; i++) {
				//一天
				l+=86400000;
				//时间戳转字符串
				String da =simpleDateFormat.format(l);
				
				//获取星期几
				Date parse = simpleDateFormat.parse(da);
				String time = dateFm.format(parse);
				
				//获取指定医师值班信息
				workings = patientMapper.DoctorWorking(ddtid);
				//那天值班
				String data = workings.getData();
				String[] split = data.split(",");
				//System.out.println(""+time);
				for(String s:split) {
					if(s.equals(time)) {
						map.put(da, workings);
					}
				}
				
			}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return map;
	}

	//
	@Override
	public Map<String, List<Doctordt>> doctorTime(String illid) {
		Map<String, List<Doctordt>> map = new HashMap<>();
		//获取科室值班医师信息
		List<Doctordt> doctorData = patientMapper.DoctorData(illid);
		
		Date date=new Date();
		
		//显示当前星期几
		SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
		String time = "";
		
		//获取当前日期
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		//字符串	时间转字符串
		String day = formatter.format(date);
		
		//获取当前时间转时间戳
		Date date2 = null;
		try {
			date2 = formatter.parse(formatter.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//date转时间戳
		long l = date2.getTime();
		for(int i = 0; i < 14 ; i++) {
			List<Doctordt> doctor = new ArrayList<>();
			String str = formatter.format(l);
			l+=86400000;
			try {
				Date parse = formatter.parse(str);
				time = dateFm.format(parse);
				for(int j=0;j<doctorData.size();j++) {
					Working workings = patientMapper.workings(doctorData.get(j).getDdtid().toString());
					String[] split = workings.getData().split(",");
					for(int k =0;k<split.length;k++) {
						if(split[k].equals(time)) {
							doctor.add(doctorData.get(j));
						}
					}
				}
				map.put(str, doctor);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
	
	
}
