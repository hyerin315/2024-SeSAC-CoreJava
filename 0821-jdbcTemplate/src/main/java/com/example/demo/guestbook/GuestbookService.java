package com.example.demo.guestbook;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GuestbookService {
	@Autowired
	private GuestbookDao dao;

	//방명록 추가
	public void addBook(Guestbook gb) {
		dao.insert(gb);
	}
	
	//번호로 검색
	public Guestbook getBook(int num) {
		return dao.select(num);
	}
 	
	//수정
	public void editBook(Guestbook gb) {
		dao.update(gb);	
	}
 	
	//삭제
	public void delBook(int num) {
		dao.delete(num);
	}
	
	//전체 목록
	public ArrayList<Guestbook> getAll() {
		return dao.selectAll();
	}
}
