package com.two.zhyy.util;




import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.two.zhyy.admin.pojo.Users;



/**
 * 该类封装登录用户相关信息
 * @author 汪怀杰
 *
 */
public class JWTUser implements UserDetails{
	private Integer id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

   public JWTUser() {
	// TODO Auto-generated constructor stub
}

    // 写一个能直接使用user创建jwtUser的构造器
    public JWTUser(Users user) {
        id = user.getId();
        username = user.getUsername();
        password = user.getPassword();//String.valueOf(user.getUserpt().getProle())
        authorities =  java.util.Collections.singleton(new SimpleGrantedAuthority("ROLE_患者"));
        }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "JwtUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }

}
