package com.two.zhyy.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.two.zhyy.admin.pojo.Doctor;
import com.two.zhyy.admin.pojo.Doctordt;
import com.two.zhyy.admin.pojo.Illness;
import com.two.zhyy.admin.pojo.Section;

/**
 * SQL 映射
 * @author 刘松杰
 *
 */
@Mapper
public interface DoctordtMapper {

	//查询医师级别信息
	@Select("select * from doctor where docid=#{id}")
	Doctor findDoctorById(int id);
	
	//查询科室信息
	@Select("select * from illness ill where ill.illid=#{id}")
	@Results({
		@Result(column = "seid",property = "section",javaType = Section.class
				,one = @One(select = "com.two.zhyy.admin.mapper.IllnessMapper.findSectById"))
	})
	Illness findById(Integer id);
	
	//查询所有医师信息
	@Select("select * from doctor doc,doctordt dod,illness ill where dod.docid=doc.docid and dod.illid=ill.illid")
	@Results({
			@Result(column = "docid",property = "doctor",javaType = Doctor.class,
			one = @One(select = "com.two.zhyy.admin.mapper.DoctordtMapper.findDoctorById")),
			
			@Result(column = "illid",property = "illness",javaType = Illness.class,
			one = @One(select = "com.two.zhyy.admin.mapper.DoctordtMapper.findById"))
	})
	List<Doctordt> findAll();
	
	//查询同一级别的医师
	@Select("select * from doctor doc,doctordt dod,illness ill where dod.docid=doc.docid and dod.illid=ill.illid and dod.docid=#{id}")
	@Results({
		@Result(column = "docid",property = "doctor",javaType = Doctor.class,
		one = @One(select = "com.two.zhyy.admin.mapper.DoctordtMapper.findDoctorById")),
		
		@Result(column = "illid",property = "illness",javaType = Illness.class,
		one = @One(select = "com.two.zhyy.admin.mapper.DoctordtMapper.findById"))
	})
	List<Doctordt> findBydocid(int id);
	
	//查询同一科室的医师
	@Select("select * from doctor doc,doctordt dod,illness ill where dod.docid=doc.docid and dod.illid=ill.illid and dod.illid=#{id}")
	@Results({
		@Result(column = "docid",property = "doctor",javaType = Doctor.class,
		one = @One(select = "com.two.zhyy.admin.mapper.DoctordtMapper.findDoctorById")),
		
		@Result(column = "illid",property = "illness",javaType = Illness.class,
		one = @One(select = "com.two.zhyy.admin.mapper.DoctordtMapper.findById"))
	})
	List<Doctordt> findByillid(int id);
}
