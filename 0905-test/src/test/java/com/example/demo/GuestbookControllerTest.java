package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.guestbook.GuestBookController;
import com.example.demo.guestbook.GuestBookDTO;
import com.example.demo.guestbook.GuestBookService;

//WebMvcTest : URL을 어떻게 가져오는지, 파라미터를 어떤 걸 가져오는지 Test
@WebMvcTest(GuestBookController.class)
public class GuestbookControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	//MockBean : 가상의 객체로 실제 DB 연동은 안됨
	@MockBean
	private GuestBookService service;
	
	//addForm test
	//MockMvc : mvc 웹의 MockTest api 제공
	//perform() : Mock 수행 메서드, get(test할 url), post()...
	//andDo() : test시 수행할 내용 작성. print() : 출력
	//andExpect() : 처리 결과 상태 지정
	@Test
	void addFromTest() {
		String params="";
		try {
			mockMvc.perform(get("/guestbook/add" + params))
			.andDo(print())
			.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//글 추가 test
	@Test
	void addTest() {
		String params = "?writer=ttt&pwd=ttt&content=test";
		try {
			mockMvc.perform(post("/guestbook/add" + params))
			.andDo(print())
			.andExpect(status().is3xxRedirection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//list 출력 test (view page로 잘 넘어가는지 test)
	@Test
	void listTest() {
		//service.getAll()의 가상 return값
		ArrayList<GuestBookDTO> list = new ArrayList<>();
		list.add(new GuestBookDTO(1, "ttt", new Date(), "ttt", "content1"));
		list.add(new GuestBookDTO(2, "aaa", new Date(), "aaa", "content2"));
		list.add(new GuestBookDTO(3, "ggg", new Date(), "ggg", "content3"));
		
		//when(): testing 시나리오에서 특정 이벤트가 발생할 때
		//thenRetrun(): 이벤트 발생시 지정한 값 return
		when(service.getAll()).thenReturn(list);
		try {
			mockMvc.perform(get("/guestbook/list"))
				.andDo(print())
				.andExpect(status().is3xxRedirection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
