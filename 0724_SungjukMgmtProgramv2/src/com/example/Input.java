package com.example;
import java.io.FileNotFoundException;
import java.util.List;

public class Input {
	private java.util.Scanner sc;   //member
	private List<StudentVO> list;       //field
	
	public Input(List<StudentVO> list) throws FileNotFoundException {
		this.sc = new java.util.Scanner(new java.io.File("sungjuk_utf8.txt"));
		this.list = list;
	}
	
	void input() {
		while(this.sc.hasNextLine()){
			String line = this.sc.nextLine();  //1101     한송이     78     87     83    78
			//문자열 파싱 ==> String [] = String 클래스의 split(정규식)
			java.util.Scanner s = new java.util.Scanner(line).useDelimiter("\\s+");
			String hakbun = s.next();  //1101
			String name = s.next();  //한송이
			int kor = s.nextInt();  //78
			int eng = s.nextInt();  //87
			int mat = s.nextInt();  //83
			int edp = s.nextInt();  //78
			StudentVO student = new StudentVO(hakbun, name, kor, eng, mat, edp);
			this.list.add(student);
		}
	}
}