package com.two.zhyy.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.two.zhyy.admin.pojo.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

}
