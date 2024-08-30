package com.example.demo.ajaxtest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
	
	@ResponseBody // 웹 페이지가 아니라 데이터를 응답으로 전달
	@GetMapping("/test1")
	public String test1(int num, String name) {
		return "hello ajax get요청 / num:" + num + "/ name:" + name;
	}
	
	
	@GetMapping("/view1")
	public String view1() {
		return "ajax/test1";
	}

	@ResponseBody
	@PostMapping("/test2")
	public String test2(int num, String name) {
		return "ajax post요청 / num:" + num + "/ name:" + name;
	}
	
	@ResponseBody
	@GetMapping("/test3")
	public Map<String, Object> test3(int num, String name) {
		Map<String, Object> map = new HashMap<>();
		map.put("num", num);
		map.put("name", name);
		return map;
	}
	

}
