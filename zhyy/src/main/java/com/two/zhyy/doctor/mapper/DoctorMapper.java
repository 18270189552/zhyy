package com.two.zhyy.doctor.mapper;

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
import com.two.zhyy.pojo.Drecord;
import com.two.zhyy.pojo.Reg;
import com.two.zhyy.pojo.Userdt;

@Mapper
public interface DoctorMapper {

	//查询对应医生id下的患者信息
	@Select("SELECT * FROM reg,userdt AS udt,doctordt AS dt WHERE reg.`udtid` = udt.`udtid` AND reg.ddtid = dt.`ddtid` AND reg.`ddtid`=#{id} AND reg.`regstate` != 0 AND TO_DAYS(reg.`regtime`)=TO_DAYS(#{time})")
	@Results({
		@Result(column = "udtid",property = "userdt",javaType = Userdt.class,
				one = @One(select = "com.two.zhyy.doctor.mapper.DoctorMapper.findByIdUserdt")),
		
		@Result(column = "ddtid",property = "doctordt",javaType = Doctordt.class,
		one = @One(select = "com.two.zhyy.doctor.mapper.DoctorMapper.findByIdDoctordt")),
		

		@Result(column = "drid",property = "drecord",javaType = Drecord.class,
		one = @One(select = "com.two.zhyy.doctor.mapper.DoctorMapper.findByIdDrecord"))
	})
	List<Reg> findAll(@Param("id")String id,@Param("time")String time);
	
	
	@Select("select * from userdt where udtid = #{id}")
	Userdt findByIdUserdt(int id);
	
	@Select("select * from doctordt where ddtid = #{id}")
	Doctordt findByIdDoctordt(int id);
	
	@Select("select * from drecord where drid = #{id}")
	Drecord findByIdDrecord(int id);
	
	//添加诊断结果
	@Insert("INSERT INTO drecord(regid,recipe,symptom,types)VALUES(#{regid},#{recipe},#{symptom},#{types})")
	int save(Drecord drecord);
	
	
	//修改诊断结果
	@Update("UPDATE reg SET drid=#{drid},regstate=#{regstate} WHERE regid=#{id}")
	int update(@Param("id")Integer id, @Param("drid") Integer drid,@Param("regstate")String stat);
	
}
