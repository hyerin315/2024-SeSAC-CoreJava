package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Input;
import com.example.Patient;

class InputTest {
	private List<Patient> list;
	
	@BeforeEach
	void init() {
		this.list = new ArrayList<Patient>();
		Input input = new Input(this.list);
		input.input();
	}
	
	@Test
	void test() {
		assertNotNull(this.list);
		assertEquals("MI", this.list.get(0).getCode());
	}
}
