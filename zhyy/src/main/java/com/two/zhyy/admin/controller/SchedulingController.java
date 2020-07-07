package com.two.zhyy.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.two.zhyy.admin.service.SchedulingService;
import com.two.zhyy.pojo.Working;

/**
 * 排班管理
 * @author 汪怀杰
 *
 */
@RestController
@RequestMapping("/admin/scheduling")
public class SchedulingController {
	@Autowired
	SchedulingService ss;
	
	//查询所有排班信息
	@GetMapping("/{id}")
	public List<Working> findByList(@PathVariable int id){
		return ss.findByAll(id);
	}
	
	@GetMapping
	public List<Working> findByName(@RequestParam String name){
		return ss.findById(name);
	}
	
	
	
	
}
