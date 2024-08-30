package com.example.demo;

import org.springframework.stereotype.Controller; //stereotype : 클래스 종류, stereotype 내 어노테이션은 new 생성 코드를 생성할 필요 없이 실행하면 자동으로 생성해줌
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//Controller : 클라이언트의 요청을 받아 처리
@Controller //fullstack 컨트롤러 : 요청하는 처리하는 메소드는 view page 경로를 반환
public class HomeController {
	
	@GetMapping("/") //전송방식이 get(링크, 주소를 쳐서 이동하는 방식)인 경우만 처리 
	// webapp 폴더가 / (root)
	public String home() {
		//1) application.properties JSP view 설정을 안했을 때 설정하는 방법
		//return "/views/index.jsp"; //home 요청이 오면 jsp가 호출됨 
		
		//2) application.properties JSP view 설정했을 때 설정하는 방법
		return "index";
	}
	

	//로그인 폼으로 가기
	@GetMapping("/member/login")
	public String login() {
		return "login";
	}
	
	//로그인 폼으로 가기
	@PostMapping("/member/login")
	public String loginResult() {
		return "loginres";
	}
	
	
//	@PostMapping("/member/join") // 전송방식 및 url이 같을 경우, 실행 에러
//	public String joinform() {
//		return "";
//	}
	
	//회원가입 완료 메세지 출력
	@PostMapping("/member/join")
	public String join() {
		return "join"; 
	}
	
	//회원가입 폼으로 가기
	@GetMapping("/member/join") // 전송방식이 다를 경우, 실행 가능
	public String joinform() {
		return "joinForm";
	}
	
}
