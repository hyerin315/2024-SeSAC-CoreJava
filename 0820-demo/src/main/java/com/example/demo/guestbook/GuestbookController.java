package com.example.demo.guestbook;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	@Autowired
	private GuestbookService service;
	
	@RequestMapping("/list")
	public String list(Model m) {
		m.addAttribute("list", service.getAll());
		return "guestbook/list";
	}
	
	@GetMapping("/edit")
	public String edit(Guestbook guestbook) {
		service.editGuestbook(guestbook);
		return "guestbook/list";
	}
	
	@GetMapping("/write")
	public String writeForm(Model m) {
		return "guestbook/write";
	}
	
	@PostMapping("/write")
	public String write(Guestbook guestbook) {
		service.writeGuestbook(guestbook);
		return "index";
	}
	
	@GetMapping("/del")
	public String del(int num, String writer, String pwd, Model m) {
		Guestbook guestbook = service.getGuestbook(num);
	
		if(guestbook == null) {
			m.addAttribute("msg", "비밀번호를 정확히 입력하세요");
		} else {
			boolean isPwdCorrect = service.checkPwd(writer, pwd);
			if(!isPwdCorrect) {
				m.addAttribute("msg", "비밀번호가 일치하지 않습니다");
			} else {
				m.addAttribute("guestbook", guestbook);
			}
		}
		
		service.delGuestbook(num);
		return "index";
	}

}
