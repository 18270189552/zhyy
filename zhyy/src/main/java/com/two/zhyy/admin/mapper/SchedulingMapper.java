package com.two.zhyy.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
/**
 *	排班设置
 * @author 汪怀杰
 *
 */
import org.apache.ibatis.annotations.Select;

import com.two.zhyy.pojo.Doctordt;
import com.two.zhyy.pojo.Illness;
import com.two.zhyy.pojo.Working;
@Mapper
public interface SchedulingMapper {
	
	/**
	 *	查询所有排班信息
	 * @return
	 */
	@Select("SELECT * FROM working AS w,doctordt AS ddt,illness AS ill WHERE w.`ddtid` = ddt.`ddtid` AND ddt.`illid` = ill.`illid` AND ill.`illid` = #{id};")
	@Results({
		@Result(column = "ddtid",property = "doctordt",javaType = Doctordt.class,one = @One(select = "com.two.zhyy.admin.mapper.SchedulingMapper.findById"))
	})
	List<Working> findByAll(int id);
	
	/**
	 * 根据id查询医生
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM doctordt AS doc,illness AS ill WHERE doc.`illid` = ill.`illid` AND doc.`ddtid` = #{id}")
	@Results(
			@Result(column = "illid",property = "illid",javaType = Doctordt.class,one = @One(select = "com.two.zhyy.admin.mapper.SchedulingMapper.findByIdIllness"))
			)
	Doctordt findById(int id);
	
	/**
	 * 查询对应的科室
	 * @param id
	 * @return
	 */
	@Select("select* from illness where illid = #{id}")
	Illness findByIdIllness(int id);
	
	/**
	 * 根据医生名称获取对应的排班信息
	 * @param name
	 * @return
	 */
	@Select("SELECT * FROM working AS w,doctordt AS ddt,illness AS ill WHERE w.`ddtid` = ddt.`ddtid` AND ddt.`illid` = ill.`illid` AND ddt.`dname` = #{name};")
	@Results({
		@Result(column = "ddtid",property = "doctordt",javaType = Doctordt.class,one = @One(select = "com.two.zhyy.admin.mapper.SchedulingMapper.findById"))
	})
	List<Working> findByNamewWorkings(String name);
	
}
