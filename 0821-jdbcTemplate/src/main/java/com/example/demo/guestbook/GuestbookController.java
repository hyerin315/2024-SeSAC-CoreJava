package com.example.demo.guestbook;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GuestbookController {
	@Autowired
	private GuestbookService service;
	
	// 방명록 목록
	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("list", service.getAll());
		return "index";
	}
	
	//방명록 작성 폼
	@GetMapping("/guestbook/add")
	public void addForm() {
	}
	
	//작성 완료
	@PostMapping("/guestbook/add")
	public String add(Guestbook gb) {
		service.addBook(gb);
		//forward 방식으로 인해 중복 등록을 방지 하기 위해 redirect 진행
		return "redirect:/"; // redirect : 사용자가 새 요청을 진행하여 이동(add, edit, delete 할 때는 redirect 사용)
	}
	
	//상세페이지
	@GetMapping("/guestbook/detail")
	public void detail(int num, Model m) {
		m.addAttribute("gb", service.getBook(num));
	}
	
	@GetMapping("/guestbook/edit")
	public String edit(Guestbook gb) {
		service.editBook(gb);
		return "redirect:/";
	}
	
	@GetMapping("/guestbook/del")
	public String del(int num) {
		service.delBook(num);
		return "redirect:/";
	}

}
