package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {
	@Autowired
	private UsersService service;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	//구매자 페이지
	@RequestMapping("/index_con")
	public String index_con() {
		System.out.println("인증 테스트_con");
		return "index_con";
	}
	
	//판매자 페이지
	@RequestMapping("/index_sel")
	public String index_sel() {
		System.out.println("인증 테스트_sel");
		return "index_sel";
	}
	
	@GetMapping("/join")
	public String joinForm() {
		return "member/join";
	}
	
	@PostMapping("/join")
	public String join(UsersDTO dto) {
		service.save(dto);
		return "redirect:/";
	}
	
	@GetMapping("/loginform")
	public String loginForm() {
		return "member/login";
	}
	
	@RequestMapping("/autherror")
	public String error() {
		return "error";
	}
	
	@RequestMapping("/auth/test")
	public String test(){
		System.out.println("인증 테스트");
		return "index_auth";
	}
	
	@RequestMapping("/auth/info")
	public String info(Model m){
		Authentication a = 
				SecurityContextHolder.getContext().getAuthentication();
		String loginId = a.getName(); //인증 user의 name
		m.addAttribute("user", service.get(loginId));
		return "member/info";
	}
	
	@GetMapping("/auth/logout")
	public String logout() {
		//인증 객체 null로 처리 -> logout 처리
		//null처리 안할 경우 : SecurityContextHolder.getContext().setAuthentication();
		SecurityContextHolder.getContext().setAuthentication(null);
		return "redirect:/";
	}
}