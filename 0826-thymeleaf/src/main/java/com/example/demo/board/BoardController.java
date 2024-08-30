package com.example.demo.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService service;
	
	@RequestMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", service.getAll());
	}
	
	@GetMapping("/add")
	public void addForm() {}
	
	@PostMapping("/add")
	public String add(Board b) {
		service.addBoard(b);
		return "redirect:/board/list";
	}
	
	@ResponseBody
	@GetMapping("/getAjax")
	public Map getAjax(int num) {
		System.out.println(num);
		Board b = service.getBoard(num);
		Map map = new HashMap();
		map.put("num", b.getNum());
		map.put("writer", b.getWriter());
		map.put("wdate", b.getWdate()+"");
		map.put("title", b.getTitle());
		map.put("content", b.getContent());
		return map;
	}
	
	@GetMapping("/detail")
	public void detail(int num, Model model) {
		model.addAttribute("b", service.getBoard(num));
	}
	
	@PostMapping("/edit")
	public String edit(Board b) {
		service.editBoard(b);
		return "redirect:/board/list";
	}
	
	@GetMapping("/del")
	public String del(int num) {
		service.delBoard(num);
		return "redirect:/board/list";
	}
	
	@GetMapping("/getbytitle")
	public String getByTitle(String title, Model m) {
		m.addAttribute("list", service.getByTitle(title));
		return "board/list";
	}
	
	@GetMapping("/getbywriter")
	public String getByWriter(String writer, Model m) {
		m.addAttribute("list", service.getByWriter(writer));
		return "board/list";
	}
}







