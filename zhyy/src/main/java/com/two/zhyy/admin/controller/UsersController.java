package com.two.zhyy.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	}
	
	//查询单个账户
	@GetMapping("/{id}")
	public Object findById(@PathVariable Integer id) {
		if(!usersRepository.findById(id).isPresent()) {
			return "未查询到数据";
		}
		return usersRepository.findById(id).get();
	}
	
	//通过医疗卡号查询账户信息
	@GetMapping("/mc")
	public List<Users> findmcid(@RequestParam("mcard") String mcard){
		return users.findmcid(mcard);
	}
	
	//修改账户信息
	@PutMapping("/{id}")
	public Object update(@PathVariable Integer id,@RequestBody Users users) {
		if(!usersRepository.findById(id).isPresent()) {
			return "未查询到数据";
		}
		users.setId(id);
		if(usersRepository.findById(id).get()!=null) {
			return usersRepository.save(users);			
		}else {
			return null;
		}
	}
	
	//删除账户信息
	@DeleteMapping("/{id}")
	public String remove(@PathVariable Integer id) {
		if(!usersRepository.findById(id).isPresent()) {
			return "未查询到数据";
		}
		usersRepository.deleteById(id);
		return "删除成功";
	}
}
