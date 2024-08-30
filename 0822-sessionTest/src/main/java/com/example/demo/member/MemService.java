package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemService {
	@Autowired
	private MemDao dao;
	
	//고객 정보 검색
	public Member getMem(String id) {
		return dao.select(id);
	}
	
	//고객 정보 수정
	public void editMem(Member mb) {
		dao.update(mb);
	}
	
	//고객 정보 추가
	public void addMem(Member mb) {
		dao.insert(mb);
	}
	
	//고객 정보 삭제
	public void delMem(String id) {
		dao.delete(id);
	}
}
