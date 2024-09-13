package com.example.demo.auth;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

//Filter class 추가
//: 요청이 올때마다 요청 header에서 token을 꺼내 유효성 체크
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

	private final TokenProvider provider;
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//원래 type으로 downcasting
		HttpServletResponse res = (HttpServletResponse)response;
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Credentials", "true");
		res.setHeader("Access-Control-Allow-Methods", "*");
		res.setHeader("Access-Control-Allow-Max-Age", "3600");
		res.setHeader("Access-Control-Allow-Headers", 
				"Origin, X-Requested-With, Content-Type, Accept, "
				+ "Authorization");
		res.setStatus(HttpServletResponse.SC_OK);
		
		String token = provider.resolveToken((HttpServletRequest)request);
		
		//header에 token이 있고 token의 파기 시간이 남아있으면 정상
		if(token != null && provider.validateToken(token)) {
			Authentication a = provider.getAuthenticate(token);
			SecurityContextHolder.getContext().setAuthentication(a);
		}
		//연결된 다음 필터 실행
		chain.doFilter(request, response);
	}
}
