package com.two.zhyy.patient.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
	
	
	@Select("SELECT * FROM userdt dt WHERE dt.`udtid`=#{id}")
	@Results({
		@Result(column = "id",property = "users",javaType = Users.class,
				one = @One(select = "com.two.zhyy.patient.mapper.PatientMapper.usersload"))
	})
	Userdt userdtload(int id);
	
	
	@Select("SELECT * FROM users u WHERE u.`id`=#{id}")
	Users usersload(int id);
////	@Select("SELECT * FROM userdt dt WHERE dt.`id`=#{id}")
//	
//	//获取reg
//	@Select("SELECT * FROM users u,reg re WHERE u.`id` = re.`id` AND re.`id` = #{id};")
//	@Results({
//		@Result(
//				column = "regid",property = "list",javaType = List.class,
//				many = @Many(select = "com.two.zhyy.patient.mapper.PatientMapper.findByReg")
//				)
//	})
//	Users regload(int id);
//	
//	
//	@Select("select regid,regtime,regstate from reg where id = #{id}")
//	List<Reg> findByReg(int id);
//	
//	//获取users
//	@Select("SELECT * FROM userdt dt WHERE dt.`udtid`=#{id}")
//	@Results({
//		@Result(column = "id",property = "users",javaType = Users.class,
//				one = @One(select = "com.two.zhyy.patient.mapper.PatientMapper.regload"))
//	})
//	Userdt usersload(int id);
//	
	
}
