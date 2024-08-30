package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Service
@Service
public class MemService {
	
	@Autowired //의존성 자동 주입 : 타입이 똑같은 객체를 new로 선언하지 않아도 자동으로 넣어줌
	private MemDAO dao;
	
	public void addMember() {
		dao.insert();
		System.out.println("service addmember");
	}

	public void getMember() {
		dao.select();
		System.out.println("service getMember");
	}
	public void getAll() {
		dao.selectAll();
		System.out.println("service getAll");
	}
	
	public void editMember() {
		dao.update();
		System.out.println("service editMember");
	}
	
	public void deleteMember() {
		dao.delete();
		System.out.println("service deleteMember");
	}
	
}
