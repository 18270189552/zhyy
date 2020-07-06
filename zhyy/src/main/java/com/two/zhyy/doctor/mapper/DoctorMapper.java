package com.two.zhyy.doctor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.two.zhyy.pojo.Doctor;
import com.two.zhyy.pojo.Reg;
import com.two.zhyy.pojo.Userdt;
import com.two.zhyy.pojo.Users;

@Mapper
public interface DoctorMapper {

	//查询对应医生id下的患者信息
	@Select("SELECT * FROM users u,userdt dt,reg r,doctor d WHERE u.id=r.udtid AND r.`udtid`=d.`docid` AND dt.id=u.id AND  d.`docid`=#{id}")
	@Results({
		@Result(column = "userpt",property = "userpt"),
		@Result(column = "users",property = "users"),
		@Result(column = "drecord",property = "drecord"),
		@Result(column = "docid",property = "docid")
	     	
	})
	List<Userdt> findAll(String id);
	
	//添加患者的诊断结果
	
	
}
