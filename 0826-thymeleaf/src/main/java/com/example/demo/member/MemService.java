package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemService {
	@Autowired
	private MemDao dao;

	public void addMem(Member m) {
		dao.insert(m);
	}

	public Member getMem(String id) {
		return dao.select(id);
	}

	public void editMem(Member m) {
		dao.update(m);
	}

	public void delMem(String id) {
		dao.delete(id);
	}
}
