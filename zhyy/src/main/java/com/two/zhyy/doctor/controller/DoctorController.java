package com.two.zhyy.doctor.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.two.zhyy.doctor.service.DoctorService;
import com.two.zhyy.pojo.Doctordt;
import com.two.zhyy.pojo.Drecord;
import com.two.zhyy.pojo.Reg;
import com.two.zhyy.pojo.Userdt;
import com.two.zhyy.pojo.Working;

import javassist.expr.NewArray;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	//控制器依赖业务逻辑的定义
	@Autowired
	DoctorService doctorService;
	
	@GetMapping("/{id}")
	public List<Reg> found(@PathVariable String id){
		return doctorService.find(id);
	}
	
	//添加诊断内容
	@PostMapping
	public int create(@RequestBody Drecord drecord) {
		return doctorService.create(drecord);
	}
	
	@PutMapping("/{id}")
	public int update(@PathVariable Integer id,@RequestBody Reg reg) {
//		reg.setRegid(id);
		return doctorService.up(id,reg.getDrecord().getDrid(),reg.getRegstate());
	}
	
	@PutMapping
	public int mod(@RequestBody HashMap<String, Object> map) {
		Map map2= (Map) map.get("working");
		Map map3 = (Map)map.get("reg");
		
		Working working = new Working();
		working.setNumber(Integer.parseInt(String.valueOf(map2.get("number"))));
		Doctordt doctordt = new Doctordt();
		doctordt.setDdtid(Integer.parseInt(String.valueOf(map2.get("ddtid"))));
		working.setDoctordt(doctordt);
		
		Reg reg = new Reg();
		reg.setDoctordt(doctordt);
		reg.setRegstate(String.valueOf(map3.get("regstate")));
		SimpleDateFormat df1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		reg.setRegtime(df1.format(new Date()));
		Userdt ud = new Userdt();
		ud.setUdtid(1);
		reg.setUserdt(ud);
		//Reg reg = (Reg) map.get("reg");
		return doctorService.mo(working, reg);
	}
	
	/**
	 * 查询已存在的患者
	 * @param idcard
	 * @return
	 */
	@GetMapping("/userdt/{idcard}")
	public Userdt findByUserdt(@PathVariable int idcard) {
		return doctorService.findByUserdt(idcard);
	}
	
	
	
	
	
	
}
