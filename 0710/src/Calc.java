
public class Calc {
	void calc(Student std) {
//		std.tot = std.kor + std.eng + std.math;
//		std.avg =  std.tot / 3.;
//		std.grade = (std.avg >=  90? 'A' : std.avg >= 80? 'B' : 
//					std.avg >= 70 ? 'C' : std.avg >= 60? 'D' : 'F');
		
		//캡슐화 후 우회 접근
		int tot = std.getKor() + std.getEng() + std.getMath();
		std.setTot(tot);
		double avg = tot / 3.;
		
		std.setAvg(avg);
		char grade = (avg >=  90? 'A' : avg >= 80? 'B' : 
					  avg >= 70 ? 'C' : avg >= 60? 'D' : 'F');
		std.setGrade(grade);
	}
}
