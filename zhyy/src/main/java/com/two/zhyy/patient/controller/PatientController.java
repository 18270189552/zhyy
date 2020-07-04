package com.two.zhyy.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.two.zhyy.patient.service.PatientService;
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
	
//	@GetMapping("/")
//	public String heom() {
//		return "撒地方乐山大佛那就";
//	}
	
}
