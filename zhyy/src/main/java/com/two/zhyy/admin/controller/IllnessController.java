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

import com.two.zhyy.admin.mapper.IllnessMapper;
import com.two.zhyy.admin.pojo.Illness;
import com.two.zhyy.admin.repository.IllnessRepository;
import com.two.zhyy.admin.service.IllnessService;

@RestController
@RequestMapping("/illness")
public class IllnessController {

	//自动注入
	@Autowired
	IllnessRepository illnessRepository;
	@Autowired
	IllnessMapper ill;
	@Autowired
	IllnessService illness;
	
	//查询所有科室信息
	@GetMapping
	public List<Illness> findAll(){
		return illnessRepository.findAll();
	}
		
	//查询单个科室信息
	@GetMapping("/{id}")
	public Object findById(@PathVariable int id){
		//System.out.println(ill.findByNum(id));
		if(ill.findByNum(id)==null) {
			return "未查询到对应的信息";
		}
		return illnessRepository.findById(id).get();
	}

	//查询同一大科下的所有科室信息
	@GetMapping("/section/{id}")
	public List<Illness> findSeid(@PathVariable int id) {
		return illness.findBySeid(id);
	}
	
	//通过大科室查询子科室
	@GetMapping("/section")
	public List<Illness> findByName(@RequestParam("name") String name){
		return illness.findByName(name);
	}
	
	//添加科室信息
	@PostMapping
	public Illness insert(@RequestBody Illness illness) {
		return illnessRepository.save(illness);
	}
	
	//删除科室信息
	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id) {
		if(ill.findByNum(id)==null) {
			return "未查询到对应的信息";
		}
		illnessRepository.deleteById(id);
		return "删除成功";
	}
	
	//修改科室信息
	@PutMapping("/{id}")
	public Object update(@PathVariable int id,@RequestBody Illness illness) {
		if(ill.findByNum(id)==null) {
			return "未查询到对应的信息";
		}
		//设置id
		illness.setIllid(id);
		if(illnessRepository.findById(id).get()!=null) {	
			return illnessRepository.save(illness);
		}else {
			return "修改失败";
		}
	}
}
