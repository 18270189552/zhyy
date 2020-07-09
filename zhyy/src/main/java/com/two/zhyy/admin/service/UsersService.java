package com.two.zhyy.admin.service;

import java.util.List;

import com.two.zhyy.admin.pojo.Users;

public interface UsersService {

	//查询所有账户信息
	List<Users> findAll();
	
	//通过医疗卡号查询账户信息
	List<Users> findmcid(String mcard);
}
