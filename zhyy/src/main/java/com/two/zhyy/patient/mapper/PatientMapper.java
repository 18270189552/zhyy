package com.two.zhyy.patient.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.two.zhyy.pojo.Log;
import com.two.zhyy.pojo.Reg;
import com.two.zhyy.pojo.Userdt;
import com.two.zhyy.pojo.Users;

/**
 * 定义SQL与数据库的交互
 * @author 小米
 *
 */
@Mapper
public interface PatientMapper {

	//定义获取指定患者病史
	@Select("SELECT * FROM reg r,userdt dt,users u WHERE r.`udtid`=dt.`udtid` AND u.`id`=dt.`id` AND dt.`idcard`=#{idcard}")
	@Results({
		@Result(column = "udtid",property = "userdt",javaType =Userdt.class,
				one = @One(select = "com.two.zhyy.patient.mapper.PatientMapper.userdtload")),
		
	})
	List<Reg> load(long idcard);
	
	//获取患者表信息
	@Select("SELECT * FROM userdt dt WHERE dt.`udtid`=#{id}")
	@Results({
		@Result(column = "id",property = "users",javaType = Users.class,
				one = @One(select = "com.two.zhyy.patient.mapper.PatientMapper.usersload"))
	})
	Userdt userdtload(int id);
	
	//获取用户表信息
	@Select("SELECT * FROM users u WHERE u.`id`=#{id}")
	Users usersload(int id);

	//修改reg表中的regstate中的状态 0(取消预约) 1(预约成功) 2(签到成功)
	@Update("UPDATE reg r SET r.`regstate`=#{regstate} WHERE r.`regid`=#{regid}")
	void update(Reg reg);
	
	//定义添加日志表（reg:挂号id（外键）,交易时间,交易状态,交易价格,）
	@Options(useGeneratedKeys = true,keyProperty = "logid")
	@Insert("INSERT INTO log(regid,logtime,logstate,logprice) VALUES(#{reg.regid},#{logtime},#{logstate},#{logprice})")
	void insert(Log log);
	
	
}
