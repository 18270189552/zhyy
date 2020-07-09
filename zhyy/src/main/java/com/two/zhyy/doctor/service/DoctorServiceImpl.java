package com.two.zhyy.doctor.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.zhyy.doctor.mapper.DoctorMapper;
import com.two.zhyy.patient.exception.NoMoneyException;
import com.two.zhyy.patient.exception.OverLoadException;
import com.two.zhyy.patient.service.PatientService;
import com.two.zhyy.pojo.Doctordt;
import com.two.zhyy.pojo.Drecord;
import com.two.zhyy.pojo.Reg;
import com.two.zhyy.pojo.Userdt;
import com.two.zhyy.pojo.Working;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorMapper DoctorMapper;
	//
	@Autowired
	PatientService PatientService;

	@Override
	public List<Reg> find(String id) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return DoctorMapper.findAll(id,simpleDateFormat.format(date));
	}


	//添加诊断内容
	@Override
	public int create(Drecord drecord) {
		
		return DoctorMapper.save(drecord);
	}


	@Override
	public int up(Integer id,Integer drid,String stat) {
		return DoctorMapper.update(id,drid,stat);
	}


	@Override
	public int mo(Working working,Reg reg) {
		
		reg.setDoctordt(working.getDoctordt());
		// TODO Auto-generated method stub
		int i = DoctorMapper.modify(working);
		
		try {
			PatientService.insertReg(reg);
		} catch (NoMoneyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OverLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}


	@Override
	public Userdt findByUserdt(int idcard) {
		// TODO Auto-generated method stub
		return DoctorMapper.findByid(idcard);
	}


	

	







	





	

}
