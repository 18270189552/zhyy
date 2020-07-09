package com.two.zhyy.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 该类封装登录用户相关信息，例如用户名，密码，权限集合等，需要实现UserDetails 接口，
 * @author 汪怀杰
 *
 */
public class JwtUtils {
	//令牌头
	public static final String TOKEN_HEADER = "Authorization";
	//令牌前缀
    public static final String TOKEN_PREFIX = "Bearer ";
	
	public static final String SUBJECT = "congge";
	//销毁时间
	public static final long EXPIRITION = 1000 * 24 * 60 * 60 * 7;
	//密钥
	public static final String APPSECRET_KEY = "congge_secret";
	//角色
    private static final String ROLE_CLAIMS = "role_";
	
	/**
	 * 生成token
	 * @param username
	 * @param role
	 * @return
	 */
	public static String createToken(String username,String role) {

		Map<String,Object> map = new HashMap<>();	
		map.put(ROLE_CLAIMS, role);
		
		String token = Jwts
				.builder()
				.setSubject(username)
				.setClaims(map)
				.claim("username",username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRITION))
				.signWith(SignatureAlgorithm.HS256, APPSECRET_KEY).compact();
		return token;
	}
	
	/**
	 * 验证token
	 * @param token
	 * @return
	 */
	public static Claims checkJWT(String token) {
		try {
			final Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
			return claims;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取用户名
	 * @param token
	 * @return
	 */
	public static String getUsername(String token){
    	Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
    	return claims.get("id").toString();
    }
	
	/**
	 * 获取用户角色
	 * @param token
	 * @return
	 */
    public static String getUserRole(String token){
    	Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
    	return claims.get("rol").toString();
    }
    
    /**
     * 是否过期
     * @param token
     * @return
     */
    public static boolean isExpiration(String token){
    	Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
    	return claims.getExpiration().before(new Date());
    }
	
//	public static void main(String[] args) {
//		String name = "acong";
//		String role = "rol";
//		String token = createToken(name,role);
//		System.out.println(token);
//		
//		Claims claims = checkJWT(token);
//		System.out.println(claims.get("username"));
//		
//		System.out.println(getUsername(token));
//		System.out.println(getUserRole(token));
//		System.out.println(isExpiration(token));
//		
//	}
	

	/**
	 * eyJhbGciOiJIUzI1NiJ9.
	 * eyJzdWIiOiJjb25nZ2UiLCJpZCI6IjExMDExIiwibmFtZSI6Im51b3dlaXNpa2kiLCJpbWciOiJ3d3cudW9rby5jb20vMS5wbmciLCJpYXQiOjE1NTQ5OTI1NzksImV4cCI6MTU1NTU5NzM3OX0.
	 * 6DJ9En-UBcTiMRldZeevJq3e1NxJgOWryUyim4_-tEE
	 * 
	 * @param args
	 */

	/*public static void main(String[] args) {

		Users user = new Users();
		user.setId("11011");
		user.setUserName("nuoweisiki");
		user.setFaceImage("www.uoko.com/1.png");
		String token = generateJsonWebToken(user);

		System.out.println(token);

		Claims claims = checkJWT(token);
		if (claims != null) {
			String id = claims.get("id").toString();
			String name = claims.get("name").toString();
			String img = claims.get("img").toString();
			
			String rol = claims.get("rol").toString();

			System.out.println("id:" + id);
			System.out.println("name:" + name);
			System.out.println("img:" + img);
			
			System.out.println("rol:" + rol);
			
			
			
		}

	}*/

}

