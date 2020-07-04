package com.two.zhyy.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.two.zhyy.patient.service.PatientService;
import com.two.zhyy.pojo.Log;
import com.two.zhyy.pojo.Reg;



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
	
	@PostMapping
	public void insert(
			@RequestBody Log log) {
		System.out.println("日志记录==============================="+log.getReg().getRegid()+":--"+log.getLogtime()+",--"+log.getLogstate()+":--"+log.getLogprice());
		patientService.createLog(log);
	}
//	@GetMapping("/")
//	public String heom() {
//		return "撒地方乐山大佛那就";
//	}
	
}
