package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class TestController {
	
	@GetMapping("/test/login")
	public void loginForm() {}
	
	@PostMapping("/test/login")
	public String login(String id, String pwd, HttpSession session) {
		// 세션 정보 확인
		System.out.println("session id: " + session.getId()); // 현재 발급받은 세션 번호
		System.out.println("CreationTime: " + session.getCreationTime()); // 세션이 생성된 시간
		System.out.println("session 마지막 접근: " + session.getLastAccessedTime()); // 마지막 접근 시간
		System.out.println("session 최대 시간: " + session.getMaxInactiveInterval()); // 최대 시간 
		
		// 로그인 처리
		// aaa, 111
		String msg = "로그인 실패";
		if(id.equals("aaa") && pwd.equals("111")) {
			session.setAttribute("loginId", "aaa");
			session.setAttribute("type", "구매자");
			msg = "로그인 성공";
		}
	
		session.setAttribute("msg", msg);
		return "index";
	}
	
	@GetMapping("/test/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
}
