/*
 * 작성자 : Henry
 * 작성일 : 2024-07-19
 * 작성목적 : 병원관리프로그램
 * 작성환경 : Windows 11 23H2(OS build 22631.3880), 
 *              JDK 17.0.11, 
 *              Eclipse IDE for Java Developers Version: 2024-06
 */
package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Patient> list = new ArrayList<Patient>();
		Input input = new Input(list);
		input.input();
		Calc calc = new Calc(list);
		calc.calc();
		Sort sort = new Sort(list);
		sort.quickSort();
		Output output = new Output(list);
		output.print();
		System.out.println("Program is Over...");
	}
}
