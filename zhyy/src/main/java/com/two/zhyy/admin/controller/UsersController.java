package com.two.zhyy.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.two.zhyy.admin.pojo.Users;
import com.two.zhyy.admin.repository.UsersRepository;
import com.two.zhyy.admin.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UsersRepository usersRepository;
	@Autowired
	UsersService users;
	
	//查询所有账户
	@GetMapping
	public List<Users> findAll(){
		return usersRepository.findAll();
//		return users.findAll();
	}
	
	//查询单个账户
	@GetMapping("/{id}")
	public Users findById(@PathVariable Integer id) {
		return usersRepository.findById(id).get();
	}
	
	//修改账户信息
	@PutMapping("/{id}")
	public Users update(@PathVariable Integer id,@RequestBody Users users) {
		users.setId(id);
		return usersRepository.save(users);
	}
	
	//删除账户信息
	@DeleteMapping("/{id}")
	public void remove(@PathVariable Integer id) {
		usersRepository.deleteById(id);
	}
}
