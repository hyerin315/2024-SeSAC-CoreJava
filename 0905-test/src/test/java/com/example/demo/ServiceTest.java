package com.example.demo;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.guestbook.GuestBookDTO;
import com.example.demo.guestbook.GuestBookService;

@SpringBootTest
public class ServiceTest {
	@Autowired
	private GuestBookService service;
	
	@Test
	void addTest() {
		//글 추가 test
		//service.saveGuestBook(new GuestBookDTO(0, "ttt", null, "111", "새 글 내용")); //실제 아이디가 아니어도 됨
		//글 수정 test
		GuestBookDTO dto = service.getGuestBook(1); //1번 글 검색
		if (dto != null) {
			dto.setWriter("ttt"); //
			dto.setContent("가나다라마");
			service.saveGuestBook(dto);
		}else {
			System.out.println("없는 글");
		}
	}
	
	@Test
	void listTest() {
		ArrayList<GuestBookDTO> list = service.getAll();
		System.out.println(list);
	}
}
