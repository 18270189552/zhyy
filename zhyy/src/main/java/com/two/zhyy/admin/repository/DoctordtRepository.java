package com.two.zhyy.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.two.zhyy.admin.pojo.Doctordt;

@Repository
public interface DoctordtRepository extends JpaRepository<Doctordt, Integer>{

}
