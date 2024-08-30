package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller
@Controller
@RequestMapping("/mem") //RequestMapping : 이 컨트롤러의 공통 Url 등록 지정, 등록하는 모든 Url 앞에 자동으로 /Member/가 붙음
public class MemController {

	@Autowired
	private MemService service;
	
	@GetMapping("/join")
	public String joinForm() {
		service.addMember();
		return "member/join";
	}
	
	@PostMapping("/join")
//	public String join(Member m) { //Member의 변수가 자동으로 들어옴 (Spring 기능) : 자동으로 Member VO의 default 생성자로 객체를 생성해서 들어옴
	public String join(@ModelAttribute("m1")Member m) { // @ModelAttribute : 커맨드 객체의 이름을 지정하게 하는 어노테이션
		System.out.println(m);//form의 name 값 = 멤버 변수명 => m.setPwd 등으로 자동으로 jsp의 id값을 호출해서 파라미터로 들어옴
		service.addMember();
		return "index";
	}
	
	//검색 url : get, view : info.jsp
	@GetMapping("/get")
	public String get() { //원래라면 프라이머리 key를 가져와 view페이지에 전달했을 것
		service.getMember();
		return "member/info";
	}
	
	//전체검색 url : getAll, view : getall.jsp
	@GetMapping("/getAll")
	public String getAll() {
		service.getAll();
		return "member/getall";
	}
	
	//수정 url : edit, view : edit.jsp
	@GetMapping("/edit")
	public String edit() {
		service.editMember();
		return "member/edit";
	}
	
	//삭제 url : delete, view : del.jsp
	@GetMapping("/delete")
	public String delete() {
		service.deleteMember();
		return "member/del";
	}
	
}
