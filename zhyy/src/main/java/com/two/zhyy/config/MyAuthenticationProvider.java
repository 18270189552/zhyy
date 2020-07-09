package com.two.zhyy.config;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.two.zhyy.admin.pojo.Users;
import com.two.zhyy.util.JWTUser;



/**
 * 自定义认证
 * @author 汪怀杰
 *
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider{
	
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String name = authentication.getName();
		String pass = authentication.getCredentials().toString();
		JWTUser u =  new JWTUser(new Users(name));
			
		return new UsernamePasswordAuthenticationToken(u, "asdfadsf", u.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
