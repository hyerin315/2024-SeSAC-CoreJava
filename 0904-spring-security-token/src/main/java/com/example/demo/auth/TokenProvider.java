package com.example.demo.auth;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.Signature;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.example.demo.users.UsersDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //필요한 member를 받는 생성자 자동 생성
@Component
public class TokenProvider {
	//token 유효 시간 
	private final long expiredTime = 1000 * 60 * 60 * 1L; //1시간
	
	Key key = Keys.hmacShaKeyFor(
			"dffasdfgeqrrthfghgfhjgdhgaipiohdfgghjghkjhkjhfsdfgjjhhgjgh".getBytes(StandardCharsets.UTF_8));
	
	private final UserDetailsService service;
	
	//token 생성하여 반환
	public String getToken(UsersDTO dto) {
		//Jwts(Javascript web token) : 제일 많이 사용함
		return Jwts.builder().setSubject(dto.getId()) //token의 제목
				// heder & claim 
				.setHeader(createHeader()) //token의 header 정보 set
				.setClaims(createClaims(dto)) //claim 정보 set 
				.setExpiration(new Date((new Date()).getTime() + expiredTime)).signWith(key, SignatureAlgorithm.HS256)
				.signWith(key, SignatureAlgorithm.HS256)
				.compact();
	}
	
	//header 정보(token 종류, 암호화 알고리즘 종류, 등록시간 등)를 생성해서 반환 : 
	public Map<String, Object> createHeader() {
		Map<String, Object> map = new HashMap<>();
		map.put("typ", "JWT");
		map.put("alg", "HS256");
		map.put("regDate", System.currentTimeMillis());
		return map;
	}
	
	//claim(인증자와 관련된 정보 등록) 생성해서 반환
	public Map<String, Object> createClaims(UsersDTO dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("username", dto.getId());
		map.put("roles", dto.getType());
		return map;
	}
	
	//claim body 반환
	private Claims getClaims(String token) {
		return (Claims) Jwts.parserBuilder().setSigningKey(key).build()
				.parse(token).getBody();
	}
	
	//username 반환
	public String getUserName(String token) {
		return (String) getClaims(token).get("username");
	}
	
	//role 반환
	public String getRole(String token) {
		return (String) getClaims(token).get("roles");
	}
		
	//요청 header에서 token을 꺼내서 반환해주는 메소드
	public String resolveToken(HttpServletRequest req) {
		return req.getHeader("token");
	}
	
	//token 유효성 검사
	public boolean validateToken(String token) {
		try {
			Claims claims = getClaims(token);
			//body에 담긴 시간을 가져와서 현재 시간보다 앞섰는지 vs 아닌지 확인
			return !claims.getExpiration().before(new Date());
		} catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	//token 인증
	public Authentication getAuthenticate(String token) {
		UserDetails user = service.loadUserByUsername(getUserName(token));
		return new UsernamePasswordAuthenticationToken(user, "", user.getAuthorities());
	}
}
