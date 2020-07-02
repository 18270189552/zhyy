package com.two.zhyy.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 授权 验证 配置文件
 * 
 * @author 汪怀杰
 *
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * 配置访问权限
	 *//*
		 * @Override protected void configure(HttpSecurity http) throws Exception {
		 * //所有请求都会进授权 http .authorizeRequests() .antMatchers("/","/*").permitAll()
		 * //设置哪些页面是所有人都可访问的 // .antMatchers("/user","/user/*").hasRole("USER") //
		 * .antMatchers("/admin","/admin/*").hasRole("ADMIN")
		 * .anyRequest().authenticated() .and() .formLogin().and() .httpBasic();
		 * 
		 * 
		 * }
		 */

}
