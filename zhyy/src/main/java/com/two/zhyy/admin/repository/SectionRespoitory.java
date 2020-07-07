package com.two.zhyy.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.two.zhyy.admin.pojo.Section;

@Repository
public interface SectionRespoitory extends JpaRepository<Section, Integer>{

}
