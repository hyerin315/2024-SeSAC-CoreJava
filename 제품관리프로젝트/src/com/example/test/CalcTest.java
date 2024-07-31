package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.Calc;
import com.example.Input;
import com.example.Product;

class CalcTest {

	@Test
	void testCalc() {
		List<Product> list = new ArrayList<Product>();
		Input input = new Input(list);
		input.fileInput();
		Calc calc = new Calc(list);
		calc.calc();
		assertEquals(7_597_000, list.get(1).getBenefit());
	}

}
