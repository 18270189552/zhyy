package com.two.zhyy.Filer;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.two.zhyy.pojo.Users;
import com.two.zhyy.util.JWTUser;
import com.two.zhyy.util.JwtUtils;

/**
 * 验证用户名密码正确后，生成一个token，并将token返回给客户端
 * 该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法 ,
 * attemptAuthentication：接收并解析用户凭证。 
 * successfulAuthentication：用户成功登录后，这个方法会被调用，我们在这个方法里生成token并返回。
 */

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	 private AuthenticationManager authenticationManager;

	    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
	        this.authenticationManager = authenticationManager;
	       // super.setFilterProcessesUrl("/auth/login");
	    }

	    @Override
	    public Authentication attemptAuthentication(HttpServletRequest request,
	                                                HttpServletResponse response) throws AuthenticationException {
	        // 从输入流中获取到登录的信息
	        try {
	        	String user = request.getParameter("username");
	        	String pass = request.getParameter("password");
	   
	        	if (user == null || pass == null) {
					throw new Exception("用户名或密码为空");
				}
	        	
	            return authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(user, pass)
	            );
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	    }

	    // 成功验证后调用的方法
	    // 如果验证成功，就生成token并返回
	    @Override
	    protected void successfulAuthentication(HttpServletRequest request,
	                                            HttpServletResponse response,
	                                            FilterChain chain,
	                                            Authentication authResult) throws IOException, ServletException {

	        JWTUser jwtUser = (JWTUser) authResult.getPrincipal();
	        System.out.println("jwtUser:" + jwtUser.toString());

	        String role = "";
	        Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();
	        for (GrantedAuthority authority : authorities){
	            role = authority.getAuthority();
	        }

	        String token = JwtUtils.createToken(jwtUser.getUsername(), role);
	        //String token = JwtTokenUtils.createToken(jwtUser.getUsername(), false);
	        // 返回创建成功的token
	        // 但是这里创建的token只是单纯的token
	        // 按照jwt的规定，最后请求的时候应该是 `Bearer token`
	        response.setCharacterEncoding("UTF-8");
	        response.setContentType("application/json; charset=utf-8");
	        String tokenStr = JwtUtils.TOKEN_PREFIX + token;
	        response.setHeader("token",tokenStr);
	    }

	    @Override
	    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
	        response.getWriter().write("authentication failed, reason: " + failed.getMessage());
	    }

}
