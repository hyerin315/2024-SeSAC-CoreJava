package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.down.DownloadController;

@WebMvcTest(DownloadController.class)
public class DownloadControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void downTest() {
		try {
			mockMvc.perform(get("/download/down?fname=20140702000133_0.jpg"))
					.andDo(print())
					.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
