package com.example.demo.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/boards")
public class BoardController {
	@Autowired
	private BoardService service;
	
	//글 작성
	@PostMapping("")
	public Map add(BoardDTO board) {
		Map map  = new HashMap();
		boolean flag = true;
		try {
			service.saveBoard(board);
		} catch (Exception e) {
			System.out.println(e);
			flag = false;
		}
		map.put("flag", flag);
		return map;
	}
	
	
	
	
	
	@RequestMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", service.getAll());
	}
	

	
	@ResponseBody
	@GetMapping("/getAjax")
	public Map getAjax(int num) {
		System.out.println(num);
		BoardDTO b = service.getBoard(num);
		Map map = new HashMap();
		map.put("num", b.getNum());
		map.put("writer", b.getWriter());
		map.put("wdate", b.getWdate()+"");
		map.put("title", b.getTitle());
		map.put("content", b.getContent());
		return map; 
	}
	
	@GetMapping("/detail")
	public String detail(int num, Model model, HttpServletRequest req, HttpServletResponse res) {
		model.addAttribute("b", service.getBoard(num));
		String val = "";
		Cookie[] c = req.getCookies();
		for (Cookie cc : c) {
			if (cc.getName().equals("today")) {
				val = cc.getValue();
				val += "/" + num;
			}
		}
		if (val.equals("")) {
			val = num + "";
		}
		res.addCookie(new Cookie("today", val));
		return "board/detail";
	}
	
	@GetMapping("/today")
	public String today(HttpServletRequest req, Model model) {
		String val = "";
		Cookie[] c = req.getCookies();
		for (Cookie cc : c) {
			if (cc.getName().equals("today")) {
				val = cc.getValue();
			}
		}
		ArrayList<BoardDTO> list = new ArrayList<>();
		if (!val.equals("")) {
			String[] val2 = val.split("/");
			for (String n : val2) {
				int num = Integer.parseInt(n);
				list.add(service.getBoard(num));
			}
		}
		model.addAttribute("list", list);
		return "board/list";
	}
	
	//글 수정
	@PostMapping("/edit")
	public String edit(BoardDTO b) {
		//수정하기 전 원본 글 정보 검색
		//-> save()는 모든 컬럼을 수정하기 때문에 누락된 값은 null이 될 수 있음 
		BoardDTO origin = service.getBoard(b.getNum());
		origin.setTitle(b.getTitle());
		origin.setContent(b.getContent());
		service.saveBoard(origin);
		return "redirect:/board/list";
	}
	
	//글 삭제
	@GetMapping("/del")
	public String del(int num) {
		service.delBoard(num);
		return "redirect:/board/list";
	}
	
	//타이틀로 검색하기
	@GetMapping("/getbytitle")
	public String getByTitle(String title, Model m) {
		m.addAttribute("list", service.getByTitle(title));
		return "board/list";
	}
	
	//작성자로 검색하기
	@GetMapping("/getbywriter")
	public String getByWriter(String writer, Model m) {
		m.addAttribute("list", service.getByWriter(writer));
		return "board/list";
	}
	
	
}
