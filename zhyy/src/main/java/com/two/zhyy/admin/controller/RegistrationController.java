package com.two.zhyy.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.two.zhyy.pojo.Reg;

/**
 * 挂号管理
 * @author 汪怀杰
 *	用于处理前端发送的请求
 */

@RestController
@RequestMapping("/admin/register")
public class RegistrationController {
	
	/**
	 * 查询所有的挂号信息
	 * @return list  挂号信息集合
	 */
	@GetMapping("/")
	public List<Reg> findByAll(){
		return new ArrayList<Reg>();
	}
	
	/**
	 * 查询对应的挂号信息
	 * @return
	 */
	@GetMapping("/{id}")
	public Reg findById() {
		return new Reg();
	}
	
	/**
	 * 删除挂号信息
	 */	
	@DeleteMapping("/{id}")
	public void del() {
		
	}
	
	
	
	
	
	
	
}
