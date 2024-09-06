package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.updown.UpController;

@WebMvcTest(UpController.class)
public class UpControllerTest{
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void upTest() {
		//가상의 파일 생성
		//param1 : 파일 전송 폼 양식의 이름(파라메터 이름)
		//param2 : 원본 파일명
		//param3 : header 정보 - 파일의 종류
		//param4 : 파일 내용
		MockMultipartFile file = new MockMultipartFile("f", "a.txt", "text/plain", "file content 아무내용 작성".getBytes());
		try {
			mockMvc.perform(MockMvcRequestBuilders.multipart("/upload/upload")
					.file(file) //MockMultipartFile
					.param("title", "title test"))
					.andDo(print())
					.andExpect(status().is3xxRedirection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
