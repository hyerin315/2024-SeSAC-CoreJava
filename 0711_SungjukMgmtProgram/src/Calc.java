
public class Calc {

	private Student[] array; // field
	
	public Calc(Student[] array) { 
		this.array = array; //이미 이 array에는 학번, 이름, 성적 등의 주소가 들어간 상태
	}
	void calc() { // 보안때문에 굳이 공개하지 말자
		for (Student std : this.array) {// 향상된 for문 : 왼쪽은 반복의 대상
			int tot = std.getKor() + std.getEng() + std.getMat() + std.getEdp();
			double avg = tot / 4.;
			char grade = (avg >= 90) ? 'A' :
							(avg >= 80) ? 'B' :
								(avg >= 70) ? 'C' :
									(avg >= 60) ? 'D' : 'F';
			std.setTot(tot);
			std.setAvg(avg);
			std.setGrade(grade);
		}
	}
	
}
