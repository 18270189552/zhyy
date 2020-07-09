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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.two.zhyy.admin.mapper.DoctordtMapper;
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
	public Object findById(@PathVariable Integer id) {
		if(!doctordtRepository.findById(id).isPresent()) {
			return "未查询到数据";
		}
		return doctordtRepository.findById(id).get();
	}
	
	//查询同一级别的医师
	@GetMapping("/doctor/{id}")
	public List<Doctordt> findBydocid(@PathVariable int id){
		return doctordt.findBydocid(id);
	}
	
	//通过级别查询医师
	@GetMapping("/doctor")
	public List<Doctordt> findByRank(@RequestParam("rank") String rank){
		return doctordt.findByRank(rank);
	}
	
	//查询同一科室的医师
	@GetMapping("/illness/{id}")
	public List<Doctordt> findByillid(@PathVariable int id){
		return doctordt.findByillid(id);
	}
	
	//通过科室查询医师
	@GetMapping("/illness")
	public List<Doctordt> findByName(@RequestParam("name") String name){
		return doctordt.findByName(name);
	}
	
	//添加单个医师
	@PostMapping
	public Doctordt insert(@RequestBody Doctordt doctordt) {
		return doctordtRepository.save(doctordt);
	}
	
	//修改医师信息
	@PutMapping("/{id}")
	public Object update(@PathVariable Integer id,@RequestBody Doctordt doctordt) {
		if(!doctordtRepository.findById(id).isPresent()) {
			return "未查询到数据";
		}
		doctordt.setDdtid(id);
		if(doctordtRepository.findById(id).get()!=null) {
			return doctordtRepository.save(doctordt);			
		}else {
			return null;
		}
	}
	
	//删除医师
	@DeleteMapping("/{id}")
	public String remove(@PathVariable Integer id) {
		if(!doctordtRepository.findById(id).isPresent()) {
			return "未查询到数据";
		}
		doctordtRepository.deleteById(id);
		return "删除成功";
	}
}
