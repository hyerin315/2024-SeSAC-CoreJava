package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Calc;
import com.example.Input;
import com.example.Patient;

class CalcTest {
private List<Patient> list;
	
	@BeforeEach
	void init() {
		this.list = new ArrayList<Patient>();
		Input input = new Input(this.list);
		input.input();
		Calc calc = new Calc(this.list);
		calc.calc();
	}
	
	@Test
	void testCalc() {
		assertEquals(97000, this.list.get(0).getMoney());
	}

}
