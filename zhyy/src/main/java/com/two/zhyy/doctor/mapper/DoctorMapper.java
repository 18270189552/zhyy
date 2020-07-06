package com.two.zhyy.doctor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.two.zhyy.pojo.Doctordt;
import com.two.zhyy.pojo.Drecord;
import com.two.zhyy.pojo.Reg;
import com.two.zhyy.pojo.Userdt;
import com.two.zhyy.pojo.Users;

@Mapper
public interface DoctorMapper {

	//查询对应医生id下的患者信息
	@Select("SELECT * FROM reg,userdt AS udt,doctordt AS dt,drecord AS dr WHERE reg.`udtid` = udt.`udtid` AND reg.ddtid = dt.`ddtid` AND reg.`drid` = dr.`drid` AND reg.`ddtid`=#{id}")
	@Results({
		@Result(column = "udtid",property = "userdt",javaType = Userdt.class,
				one = @One(select = "com.two.zhyy.doctor.mapper.DoctorMapper.findByIdUserdt")),
		
		@Result(column = "ddtid",property = "doctordt",javaType = Doctordt.class,
		one = @One(select = "com.two.zhyy.doctor.mapper.DoctorMapper.findByIdDoctordt")),
		

		@Result(column = "drid",property = "drecord",javaType = Drecord.class,
		one = @One(select = "com.two.zhyy.doctor.mapper.DoctorMapper.findByIdDrecord"))
	})
	List<Reg> findAll(String id);
	
	
	@Select("select * from userdt where udtid = #{id}")
	Userdt findByIdUserdt(int id);
	
	@Select("select * from doctordt where ddtid = #{id}")
	Doctordt findByIdDoctordt(int id);
	
	@Select("select * from drecord where drid = #{id}")
	Drecord findByIdDrecord(int id);
}
