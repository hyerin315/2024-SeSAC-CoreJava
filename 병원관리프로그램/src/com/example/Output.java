package com.example;

import java.util.List;

public class Output {
	private List<Patient> list;
	
	public Output(List<Patient> list) {
		this.list = list;
	}

	public void print() {
		this.printLabel();
		this.list.forEach(p -> System.out.println(p));
		System.out.println("--------------------------------------------------------------------------");
	}
	
	private void printLabel() {
		System.out.println("                              <<병원관리프로그램>>");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("번호\t\t진찰부서\t\t진찰비\t\t     입원비\t   진료비");
		System.out.println("--------------------------------------------------------------------------");
	}
}
