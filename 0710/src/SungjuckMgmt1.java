
public class SungjuckMgmt1 {

	public static void main(String[] args) {
		Student younghee = new Student();
		SungjuckMgmt1 d = new SungjuckMgmt1();
		
		//d.input(younghee);
		//System.out.println("영의희 국어점수 : " + younghee.kor);
		//d.calc(younghee);
		//d.output(younghee);
		
		// class로 분리하여 사용하기
		new Input().input(younghee); //한 번만 쓸거면 이렇게 써도 됨
		new Calc().calc(younghee);
		new Output().output(younghee);
		
	}
	
//	void input(Student std) {// Call by Ref / Student std는 지역변수이므로, 다른 메소드에는 겹쳐지지 않음
//		// 입력받기
//		java.util.Scanner sc = new java.util.Scanner(System.in);
//		System.out.print("학번 : "); std.hakbun = sc.next();
//		System.out.print("국어 : "); std.kor = sc.nextInt();
//		System.out.print("영어 : "); std.eng = sc.nextInt();
//		System.out.print("수학 : "); std.math = sc.nextInt();
//	}
//	void calc(Student std) {
//		// 계산하기
//		std.tot = std.kor + std.eng + std.math;
//		std.avg =  std.tot / 3.;
//		std.grade = (std.avg >=  90? 'A' : std.avg >= 80? 'B' : 
//					std.avg >= 70 ? 'C' : std.avg >= 60? 'D' : 'F');
//	}
//	void output(Student std) { // 0이 아닌 것
//		// 출력하기
//		System.out.println("학군\t국어\t영어\t수학\t총점");
//		System.out.println("==============================");
//		System.out.printf("%-10s%5d%5d%5d%5d%7.1f%3c%n", //-는 왼쪽 정렬
//				std.hakbun, std.kor, std.eng, std.math, 
//				std.tot, std.avg, std.grade);			
//	}

}
