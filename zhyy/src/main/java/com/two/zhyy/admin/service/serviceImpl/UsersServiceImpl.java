package com.two.zhyy.admin.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.zhyy.admin.mapper.UsersMapper;
import com.two.zhyy.admin.pojo.Users;
import com.two.zhyy.admin.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

	//自动注入
	@Autowired
	UsersMapper usersMapper;
	
	@Override
	public List<Users> findAll() {
		return usersMapper.findAll();
	}

}
