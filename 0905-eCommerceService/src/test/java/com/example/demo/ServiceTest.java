package com.example.demo;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.guestbook.GuestBookService;
import com.example.demo.guestbook.GuestBookDTO;

@SpringBootTest
public class ServiceTest {
	@Autowired
	private GuestBookService service;
	
	@Test
	void addTest() {
		service.saveGuestBook(new GuestBookDTO(0, "aaa", null, "111", "새 글 내용"));
	}
	
	@Test
	void listTest() {
		ArrayList<GuestBookDTO> list = service.getAll();
		System.out.println(list);
	}

}
