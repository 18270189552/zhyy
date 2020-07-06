package com.two.zhyy.patient.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.two.zhyy.pojo.Doctordt;
import com.two.zhyy.pojo.Log;
import com.two.zhyy.pojo.Medicalcard;
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
	
	//定义添加用户信息表的信息
	@Insert("INSERT INTO users(mcid,username,`password`) VALUES(#{medicalcard.mcid},#{username},#{password})")
	void insertUsers(Users users);
	
	//定义添加患者表的信息
	@Options(useGeneratedKeys = true,keyProperty = "udtid")
	@Insert("INSERT INTO userdt(id,`name`,idcard,phone,age,sex) VALUE(#{users.id},#{name},#{idcard},#{phone},#{age},#{sex})")
	void insertUserdt(Userdt userdt);
	
	//定义查询获取指定医师的ID与信息
	@Select("SELECT * FROM doctordt d WHERE d.dname=#{dname}")
	Doctordt selectDoctordt(String dname);
	
	//定义查询指定的获取到用户的ID与信息
	@Select("SELECT * FROM users u WHERE u.username=#{username}")
	Users selectUsers(String username);
	
	//定义添加患者挂号表信息
	@Insert("INSERT INTO reg(logid,udtid,ddtid,regtime) VALUES(#{log.logid},#{userdt.udtid},#{doctordt.ddtid},#{regtime})")
	void insertReg(Reg reg);
	
	//定义添加卡号的信息
	@Options(useGeneratedKeys = true,keyProperty = "mcid")
	@Insert("INSERT INTO medicalcard(id,mcard,money) VALUES(#{users.id},#{mcard},#{money})")
	void insertcard(Medicalcard card);
	
	//定义修改用户的卡号绑定
	@Update("UPDATE users u SET u.mcid=#{mcids} WHERE u.id=#{ids}")
	void updateusers(@Param("mcids") int mcids,@Param("ids") int ids);
	
	//定义添加日志表（reg:挂号id（外键）,交易时间,交易状态,交易价格,）
	@Options(useGeneratedKeys = true,keyProperty = "logid")
	@Insert("INSERT INTO log(regid,logtime,logstate,logprice) VALUES(#{reg.regid},#{logtime},#{logstate},#{logprice})")
	void insert(Log log);
	
	
}
