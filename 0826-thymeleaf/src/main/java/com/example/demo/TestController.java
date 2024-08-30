package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("/test1")
	public String test1(Model m) {
		m.addAttribute("name", "aaa");
		m.addAttribute("tel", "1234");
		return "index"; //template/index.html
	}
	
	@GetMapping("/test2")
	public String test2(String name) {
		System.out.println("name:"+name);
		return "index";
	}
	
	@GetMapping("/test3")
	public String test3(HttpSession session) {
		session.setAttribute("loginId", "aaa");
		return "index";
	}
	
	@GetMapping("/test4")
	public String test4(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@GetMapping("/test5")
	public String test5(Model m) {
		ArrayList<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		m.addAttribute("list", list);
		return "index"; //template/index.html
	}
}





