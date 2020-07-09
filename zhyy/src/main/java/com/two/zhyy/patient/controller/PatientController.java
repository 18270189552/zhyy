package com.two.zhyy.patient.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.two.zhyy.patient.exception.NoMoneyException;
import com.two.zhyy.patient.exception.OverLoadException;
import com.two.zhyy.patient.service.PatientService;
import com.two.zhyy.pojo.Doctordt;
import com.two.zhyy.pojo.Illness;
import com.two.zhyy.pojo.Log;
import com.two.zhyy.pojo.Medicalcard;
import com.two.zhyy.pojo.Reg;
import com.two.zhyy.pojo.Section;
import com.two.zhyy.pojo.Userdt;
import com.two.zhyy.pojo.Users;



/**
 * 患者控制器
 * @author 小米
 *
 */
@RestController
@RequestMapping("/pat")
public class PatientController {

	//自动注入
	@Autowired
	PatientService patientService;
	
	private String msg;
	
	//获取指定的患者病史
	@GetMapping("/{idcard}")
	public List<Reg> findByid(@PathVariable long idcard){
		System.out.println("一系列===================================");
		return patientService.assfind(idcard);
	}
	
	//修改reg表中的regstate中的状态 0(取消预约) 1(预约成功) 2(签到成功)
	@PutMapping("/{id}")
	public void update(
			@PathVariable int id,
			@RequestBody Reg reg) {
		reg.setRegid(id);
		System.out.println("修改==================================="+reg.getRegid()+"："+reg.getRegstate());
		patientService.update(reg);
	}
	
	//定义添加日志表（交易时间,交易状态,交易价格,reg:挂号id（外键））
	@PostMapping
	public void insert(
			@RequestBody Log log) {
		System.out.println("日志记录==============================="+":--"+log.getLogtime()+",--"+log.getLogstate()+":--"+log.getLogprice());
		patientService.createLog(log);
	}
	
	//定义添加用户信息表的信息
	@PostMapping("/users")
	public void insertUsers(
			@RequestBody Users users) {
		System.out.println("添加用户信息===================");
		patientService.insertUsers(users);
	}
	
	//定义添加患者表的信息
	@PostMapping("/userdt")
	public int insertUserdt(
			@RequestBody Userdt userdt) {
		patientService.insertUserdt(userdt);
		System.out.println("患者表的信息==============="+userdt.getUdtid());
		return userdt.getUdtid();
	}
	
	//定义添加卡号的信息
	@PostMapping("/card")
	public void insertcard(
			@RequestBody Medicalcard card) {
		System.out.println("添加卡号==============");
		patientService.insertcard(card);
	}
	
	//定义添加挂号的信息
	@PostMapping("/reg")
	public String seleReg(
			@RequestBody Reg reg) {
		System.out.println("添加挂号================");
		try {
			patientService.insertReg(reg);
		} catch (NoMoneyException e) {
			// TODO Auto-generated catch block
			msg = e.getMessage();
			System.err.println(e.getMessage());
		} catch (OverLoadException e) {
			msg = e.getMessage();
			System.err.println(e.getMessage());
		}
		return msg;
	}
	
	
	
	//-----------------------------------------------------------------------------
	//获取一级科室信息
	@GetMapping("/section")
	public List<Section> sectionAll(){
		return patientService.sectionAll();
	}
		
	//显示二级科室
	@GetMapping("/section/{seid}")
	public List<Illness> illnessId(@PathVariable String seid){
		return patientService.illnesseId(seid);
	}
		
	//显示科室下的医师
	@GetMapping("/section/{illid}/doctor")
	public List<Doctordt> DoctorId(@PathVariable String illid){
		return patientService.doctorId(illid);
	}
		
	//显示指定科室14天的的值班医师
	@GetMapping("/doctor/{illid}")
	public Map<String, List<Doctordt>> DoctorTime(@PathVariable String illid){
		return patientService.doctorTime(illid);
	}
		
//	//显示14天科室的医师排班
//	@GetMapping("/section/doctor/{illid}")
//	public Map<String, Object> DoctorDate(@PathVariable String illid){
//		return patientService.doctorDate(illid);
//	}
		
	//显示14天医师的排版
	@GetMapping("/patient/scheduling/{ddtid}")
	public Map<String, Object> DoctorWorking(@PathVariable String ddtid){
		return patientService.doctorWorking(ddtid);
	}

}
