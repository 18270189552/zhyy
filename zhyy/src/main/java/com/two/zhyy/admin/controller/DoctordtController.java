package com.two.zhyy.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.two.zhyy.admin.pojo.Doctordt;
import com.two.zhyy.admin.repository.DoctordtRepository;
import com.two.zhyy.admin.service.DoctordtService;

@RestController
@RequestMapping("/doctordt")
public class DoctordtController {

	//自动注入
	@Autowired
	DoctordtRepository doctordtRepository;
	@Autowired
	DoctordtService doctordt;
	
	//查询所有医师的信息
	@GetMapping
	public List<Doctordt> findAll(){
		return doctordtRepository.findAll();
	}
	
	//查询单个医师
	@GetMapping("/{id}")
	public Doctordt findById(@PathVariable Integer id) {
		return doctordtRepository.findById(id).get();
	}
	
	//查询同一级别的医师
	@GetMapping("/doctor/{id}")
	public List<Doctordt> findBydocid(@PathVariable int id){
		return doctordt.findBydocid(id);
	}
	
	//查询同一科室的医师
	@GetMapping("/illness/{id}")
	public List<Doctordt> findByillid(@PathVariable int id){
		return doctordt.findByillid(id);
	}
	
	//添加单个医师
	@PostMapping
	public Doctordt insert(@RequestBody Doctordt doctordt) {
		return doctordtRepository.save(doctordt);
	}
	
	//修改医师信息
	@PutMapping("/{id}")
	public Doctordt update(@PathVariable Integer id,@RequestBody Doctordt doctordt) {
		doctordt.setDdtid(id);
		return doctordtRepository.save(doctordt);
	}
	
	//删除医师
	@DeleteMapping("/{id}")
	public void remove(@PathVariable Integer id) {
		doctordtRepository.deleteById(id);
	}
}
