package com.two.zhyy.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.two.zhyy.doctor.service.DoctorService;
import com.two.zhyy.pojo.Drecord;
import com.two.zhyy.pojo.Reg;
import com.two.zhyy.pojo.Userdt;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	//控制器依赖业务逻辑的定义
	@Autowired
	DoctorService doctorService;
	
	@GetMapping("/{id}")
	public List<Reg> found(@PathVariable String id){
		return doctorService.find(id);
	}
	
	@PostMapping
	public int create(@RequestBody Drecord drecord) {
		return doctorService.create(drecord);
	}
	
	@PutMapping("/{id}")
	public int update(@PathVariable Integer id,@RequestBody Reg reg) {
//		reg.setRegid(id);
		return doctorService.up(id,reg.getDrecord().getDrid(),reg.getRegstate());
	}
	
	
	
}
