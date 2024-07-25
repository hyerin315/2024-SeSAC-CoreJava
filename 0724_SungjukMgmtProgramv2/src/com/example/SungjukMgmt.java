package com.example;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class SungjukMgmt {
	public static void main(String[] args) throws FileNotFoundException {
		List<StudentVO> list = new ArrayList<StudentVO>();
		Input input = new Input(list);        
		input.input();
		
		Calc calc = new Calc(list);             
		calc.calc();
		
		//Sort sort = new Sort(list);             
		//sort.quickSorting();
		
		Output output = new Output(list);   output.output();
		System.out.println("Program is over...");
	}
}
