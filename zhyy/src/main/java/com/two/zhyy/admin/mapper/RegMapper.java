package com.two.zhyy.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.two.zhyy.pojo.Doctor;
import com.two.zhyy.pojo.Doctordt;
import com.two.zhyy.pojo.Drecord;
import com.two.zhyy.pojo.Illness;
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
		property = "userdt",
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
	@Select("SELECT * FROM doctordt AS dt,doctor AS doc,illness AS ill WHERE dt.`docid` = doc.`docid` AND dt.illid = ill.`illid` AND  ddtid = #{id};")
	@Results({
		@Result(column = "illid",property = "illid",javaType = Illness.class,
				one = @One(select = "com.two.zhyy.admin.mapper.RegMapper.findByIdIllness"))
	})
	Doctordt findByIdDoctordt(int id);
	
	/**
	 * 科室
	 * @param id
	 * @return
	 */
	@Select("SELECT * from illness where illid = #{id}")
	Illness findByIdIllness(int id);
	
	/**
	 * 查询处方
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM drecord AS dr WHERE dr.`drid` = #{id};")
	Drecord findByIdDrecord(int id);
	
	/**
	 * 查询单个挂号
	 * @param id 挂号id
	 * @return
	 */
	@Select("SELECT * FROM reg,`log` AS l,userdt AS udt WHERE reg.`logid` = l.`logid` AND reg.`udtid` = udt.`udtid` AND  udt.`idcard` = #{id} AND reg.`regstate`= 1;")
	@Results({
		@Result(column = "logid",
				property = "log",
				javaType = Log.class,
				one = @One(select = "com.two.zhyy.admin.mapper.RegMapper.findByIdLog")),
		
		@Result(column = "udtid",
		property = "userdt",
		javaType = Userdt.class,
		one = @One(select = "com.two.zhyy.admin.mapper.RegMapper.findByIdUsersdt"))
	})
	List<Reg> findByIdReg(long id);
	
	/**
	 * 删除挂号信息
	 * @param id 挂号id
	 * regstate = 3 为删除状态
	 */
	@Update("UPDATE reg SET regstate = 3 WHERE regid = #{id};")
	int delete(int id);
	
}
