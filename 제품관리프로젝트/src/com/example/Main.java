package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Product> list = new ArrayList<Product>();
		Input input = new Input(list);
		input.fileInput();
		Calc calc = new Calc(list);
		calc.calc();
		Sort sort = new Sort(list);
		sort.quickSort();
		Output output = new Output(list);
		output.print();
		System.out.println("Program is over...");
	}
}
