package com.example;

import java.util.List;
import java.util.Scanner;

public class Input {
	private Scanner sc;
	private List<Patient> list;
	
	public Input(List<Patient> list) {
		this.sc = new Scanner(System.in);
		this.list = list;
	}

	public void input() {
		String i_o = null;
		do {
			System.out.print("번호 : ");    int number = this.sc.nextInt();
			System.out.print("진료코드 : ");  String code = this.sc.next();
			System.out.print("입원일수 : ");   int days = this.sc.nextInt();
			System.out.print("나이 : ");     int age = this.sc.nextInt();
			Patient p = new Patient(number, code, days, age);
			this.list.add(p);
			System.out.print("입력 / 출력(I/O) ? ");
			i_o = this.sc.next();
		}while(i_o.toUpperCase().equals("I"));
	}

}
