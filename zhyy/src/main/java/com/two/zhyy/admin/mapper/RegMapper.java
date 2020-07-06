package com.two.zhyy.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.two.zhyy.pojo.Doctordt;
import com.two.zhyy.pojo.Drecord;
import com.two.zhyy.pojo.Log;
import com.two.zhyy.pojo.Reg;
import com.two.zhyy.pojo.Userdt;
/**
 * 挂号管理数据仓库操作
 * @author 汪怀杰
 *
 */
@Mapper
public interface RegMapper {
	
	/**
	 * 查询所有挂号
	 * @return
	 */
	@Select("SELECT * FROM reg,`log` AS l,userdt AS udt, doctordt AS ddt,drecord AS dr WHERE reg.`logid` = l.`logid` AND reg.`udtid` = udt.`udtid` AND reg.`ddtid` = ddt.`ddtid` AND reg.`drid` = dr.`drid` AND reg.`drid` = dr.`drid`;")
	@Results({
		@Result(column = "logid",
				property = "log",
				javaType = Log.class,
				one = @One(select = "com.two.zhyy.admin.mapper.RegMapper.findByIdLog")),
		
		@Result(column = "udtid",
		property = "udt",
		javaType = Userdt.class,
		one = @One(select = "com.two.zhyy.admin.mapper.RegMapper.findByIdUsersdt")),
	
		@Result(column = "ddtid",
		property = "doctordt",
		javaType = Doctordt.class,
		one = @One(select = "com.two.zhyy.admin.mapper.RegMapper.findByIdDoctordt")),
		
		@Result(column = "drid",
		property = "drecord",
		javaType = Drecord.class,
		one = @One(select = "com.two.zhyy.admin.mapper.RegMapper.findByIdDrecord"))
		
	})
	List<Reg> findByAllReg();
	
	/**
	 * 查询日志
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM `log` WHERE logid = #{id}")
	Log findByIdLog(int id);
	
	/**
	 * 查询用户详情表
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM userdt WHERE udtid = #{id}")
	Userdt findByIdUsersdt(int id);
	
	/**
	 * 查询医生详情
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM doctordt WHERE ddtid = #{id};")
	Doctordt findByIdDoctordt(int id);
	
	/**
	 * 查询处方
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM drecord WHERE drid = #{id};")
	Drecord findByIdDrecord(int id);
	
	
}
