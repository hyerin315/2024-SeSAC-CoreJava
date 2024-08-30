package com.example.demo.city;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/city")
public class CityController {
	@Autowired
	private CityService service;

	//Model : View 페이지에 전달할 값을 담는 용도, 파라미터로 지정하면 자동으로 객체를 생성하고 값을 View 페이지로 자동으로 전달됨
	@GetMapping("/detail")
	public String detail(int id, Model m) { 
		City city = service.getCity(id);
		if(city == null) {
			m.addAttribute("msg", "없는 아이디");
		} else {
			m.addAttribute("city", city);
		}
		//m.addAttribute("c", city); //addAttribute("View 페이지에서 부를 이름", 전달할 값) 
		System.out.println(city);
		return "city/detail";
	}
	
	//검색할 도시의 id를 받음
	@GetMapping("/info")
	public String info() {
		return "city/info";
	}

	@GetMapping("/add")
	public String addForm(Model m) {
		ArrayList<String> list = new ArrayList<>();
		list.add("ABW");
		list.add("AIA");
		list.add("BDI");
		list.add("BRA");
		list.add("CUB");
		list.add("GMB");
		list.add("IND");
		m.addAttribute("list", list);
		
		//아래 for문이 add.jsp의 <c:forEach>와 같음
		/*
		 * for (String code:list) {
		 * 
		 * }
		 */
		return "city/add";
	}
	
	@PostMapping("/add")
	public String add(City city) {
		service.addCity(city);
		return "index";
	}
	
	@RequestMapping("/list")
	public String list(Model m) {
		m.addAttribute("list", service.getAll());
		return "city/list";
	}
	
	@PostMapping("/edit")
	public String edit(City city) {
		service.editCity(city);
		return "index";
	}
	
	@GetMapping("/del")
	public String del(int id) {
		service.delCity(id);
		return "index";
	}
	

}
