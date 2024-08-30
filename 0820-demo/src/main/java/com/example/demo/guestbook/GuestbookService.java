package com.example.demo.guestbook;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GuestbookService {
	@Autowired
	private GuestbookDao dao;
	
	public Guestbook getGuestbook(int num) {
		return dao.select(num);
	}

	public ArrayList<Guestbook> getAll() {
		return dao.selectAll();
	}
	
	public void writeGuestbook(Guestbook guestbook) {
		dao.insert(guestbook);
	}
	
	public void editGuestbook(Guestbook guestbook) {
		dao.update(guestbook);
	}
	
	public void delGuestbook(int num) {
		dao.delete(num);
	}
	
	public boolean checkPwd(String writer, String pwd) {
		String correctPwd = dao.getPwdByWriter(writer);
        return correctPwd != null && correctPwd.equals(pwd);
	}
}
