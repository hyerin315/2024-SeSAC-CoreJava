package com.example;
import java.util.List;

public class Calc {
	private List<StudentVO> list;   //field
	public Calc(List<StudentVO> list) {
		this.list = list;
	}
	void calc() {
		//for(Student std : this.array) {
		this.list.forEach(std -> {
			int tot = std.getKor() + std.getEng() + std.getMat() + std.getEdp();
			double avg = tot / 4.;
			char grade = (avg >= 90) ? 'A' : 
									(avg >= 80) ? 'B' : 
										(avg >= 70) ? 'C' :
											(avg >= 60) ? 'D' : 'F';
			std.setTot(tot);    std.setAvg(avg);   std.setGrade(grade);
		});
	}
}