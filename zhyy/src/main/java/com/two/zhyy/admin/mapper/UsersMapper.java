package com.two.zhyy.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.two.zhyy.admin.pojo.Medicalcard;
import com.two.zhyy.admin.pojo.Userpt;
import com.two.zhyy.admin.pojo.Users;

@Mapper
public interface UsersMapper {
	
	//查询用户级别信息
	@Select("select * from userpt where ptid=#{id}")
	Userpt findUserptById(int id);

	//查询医疗卡信息
	@Select("select * from medicalcard where mcid=#{id}")
	Medicalcard findmcById(int id);
	
	//查询所有账户信息
	@Select("select * from users u,userpt pt,medicalcard mc where u.mcid=mc.mcid and u.ptid=pt.ptid")
	@Results({
			@Result(column = "ptid",property = "userpt",javaType = Userpt.class,
					one = @One(select = "com.two.zhyy.admin.mapper.UsersMapper.findUserptById")),
			
			@Result(column = "mcid",property = "medicalcard",javaType = Medicalcard.class,
					one = @One(select = "com.two.zhyy.admin.mapper.UsersMapper.findmcById"))
	})
	List<Users> findAll();
}
