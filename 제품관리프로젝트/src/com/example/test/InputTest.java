package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.Input;
import com.example.Product;

class InputTest {
	@Test
	void testFileInput() {
		List<Product> list = new ArrayList<Product>();
		Input input = new Input(list);
		input.fileInput();
		//assertNotNull(list);
		assertEquals("DISKETTE", list.get(5).getName());
	}

}
