package com.example.demo.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService service;
	
	@GetMapping("/join")
	public void joinForm() {
	}
	
	@PostMapping("/join")
	public String join(MemberDTO m) {
		service.saveMember(m);
		return "index";
	}
	
	@GetMapping("/login")
	public void loginFrom() {
		
	}
	
	@PostMapping("/login")
	public String login(MemberDTO m, HttpSession session, Model model) {
		MemberDTO mdto = service.getMember(m.getId());
		if(mdto != null && mdto.getPwd().equals(m.getPwd())) {
			session.setAttribute("loginId", mdto.getId());
			session.setAttribute("type", mdto.getType());
		} else {
			model.addAttribute("msg", "로그인 실패");
		} return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@ResponseBody
	@GetMapping("/idcheckAjax")
	public Map idcheckAjax(String id) {
		Map map = new HashMap();
		boolean flag = false;
		if (service.getMember(id) == null) {
			flag = true;
		}
		map.put("flag", flag);
		return map;
	}
	
	@GetMapping("/detail")
	public void myInfo(HttpSession session, Model m) {
		m.addAttribute("m", service.getMember((String)session.getAttribute("loginId")));
	}
	
	
	//1) MemberService에 return이 없을 경우
//	public String edit(MemberDTO m, HttpSession session) {
//		service.saveMember(m);
//		Member m2 = service.getMember(m.getId());
//		session.setAttribute("type", m2.getType());
//		return "redirect:/memebr/";
	@PostMapping("/edit")
	public String edit(MemberDTO m, HttpSession session) {
		MemberDTO mem = service.saveMember(m);
		session.setAttribute("type", mem.getType());
		return "redirect:/";
	}
	
	@GetMapping("/out")
	public String out(HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		service.delMember(loginId);
		return "redirect:/member/logout";
	}
	
}
