package com.example.demo.auth;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//인증 성공시 실행
public class MySuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String loginId = authentication.getName(); //로그인 인증을 통과한 Id
		System.out.println("로그인 성공 : loginId" + loginId);
		String path = "";
		
		if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("구매자"))){
			System.out.println("구매자");
			path = "/index_con";
		} else if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("판매자"))){
			System.out.println("판매자");
			path = "/index_sel";
		} else {
			System.out.println("권한을 알 수 없음");
			path = "/";
		}
		//path 경로로 forward로 이동
		request.getRequestDispatcher(path).forward(request, response);
	}
}
