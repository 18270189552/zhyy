package com.two.zhyy.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.two.zhyy.admin.pojo.Illness;
import com.two.zhyy.admin.pojo.Section;

/**
 * SQL映射
 * @author 刘松杰
 *
 */
@Mapper
public interface IllnessMapper {
	
	//查询单个大科室信息
	@Select("select * from section where seid=#{id}")
	Section findSectById(int id);

	//查询所有科室信息
	@Select("select * from illness ill,section sec where ill.seid=sec.seid")
	@Results({
		@Result(column = "seid",property = "section",javaType = Section.class
				,one = @One(select = "com.two.zhyy.admin.mapper.IllnessMapper.findSectById"))
	})
	List<Illness> findAll();
	
	//查询单个科室信息
	@Select("select * from illness ill where ill.illid=#{id}")
	@Results({
		@Result(column = "seid",property = "section",javaType = Section.class
				,one = @One(select = "com.two.zhyy.admin.mapper.IllnessMapper.findSectById"))
	})
	Illness findById(Integer id);
	
	//添加科室
	@Insert("insert into illness(seid,illnessname) values(#{seid},#{illnessname})")
	void insert(Illness illness);
	
	//查询同一大科下的所有科室信息
	@Select("select * from illness ill,section sec where ill.seid=sec.seid and ill.seid=#{id}")
	@Results({
		@Result(column = "seid",property = "section",javaType = Section.class
				,one = @One(select = "com.two.zhyy.admin.mapper.IllnessMapper.findSectById"))
	})
	List<Illness> findBySeid(int id);
	

	@Select("select * from illness ill,section sec where ill.seid=sec.seid and sec.sectionname=#{name}")
	@Results({
		@Result(column = "seid",property = "section",javaType = Section.class
				,one = @One(select = "com.two.zhyy.admin.mapper.IllnessMapper.findSectById"))
	})
	List<Illness> findName(String name);

	//通过大科室查询子科室
	@Select("select * from illness ill,section sec where ill.seid=sec.seid and sec.sectionname=#{name}")
	@Results({
		@Result(column = "seid",property = "section",javaType = Section.class
				,one = @One(select = "com.two.zhyy.admin.mapper.IllnessMapper.findSectById"))
	})
	List<Illness> findByName(String name);
	
	@Select("SELECT illid FROM illness WHERE illid = #{id};")
	String findByNum(int id);
 
}
