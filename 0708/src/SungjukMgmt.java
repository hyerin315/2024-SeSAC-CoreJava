
public class SungjukMgmt {

	public static void main(String[] args) {// main은 시작과 끝만 결정해야함 
		// 타이어, 핸들 - 자동차 : 집합관계
		// 학교 - 학생 : 상속관계
		// 학생 - 성적 관리 : 사용하다
		
		Student chulsu = new Student(); // 참조변수(8byte)
		// new를 통해 선언해줘서 땅을 사야함 -> chulsu는 Stack에 올라감 (chulsu는 번지를 갖고 있음)
		// chulsu(부품)는 Student(컴포넌트)에 종속적 -> 컴포넌트를 합쳐서 하나의 완성품(매니지먼트) 제작
		// 작은 부품을 조합해 큰 부품을 만드는 것 - bottom up 방식 
		// heap은 모눈종이처럼 칸칸으로 되어 있음
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		String y_n = null;
		
		do {
			System.out.print("학번 : "); 
			chulsu.hakbun = sc.next(); // 철수의 학번 방에 배달
			// nextLine()을 쓸 경우, 값과 함께 엔터도 같이 포함되어 저장됨
			// 그래서 루프를 돌 때, Again에서 y를 누르고 엔터를 누르면 학번 입력을 안받고 넘어가는 경우가 있음 
			// next는 공백을 만날때 넘어감
			
			
			// 성적 입력받기
			System.out.print("국어 : ");
			chulsu.kor = sc.nextInt(); // 철수의 국어 방으로 배달
		
			System.out.print("영어 : ");
			chulsu.eng = sc.nextInt(); // 철수의 영어 방으로 배달
			
			System.out.print("수학 : ");
			chulsu.math = sc.nextInt(); // 철수의 수학 방으로 배달
	
			chulsu.tot = chulsu.kor + chulsu.eng + chulsu.math;
			chulsu.avg = chulsu.tot / (double) 3; // 자동형변환시켜서 실수까지 보이게 하자
			//chulsu.avg = chulsu.tot / (double) 3.; // 3. or 3.0 이렇게 자동형변환 시켜도 됨
			
			// 성적 알려주기
			chulsu.grade = '\0'; // ASLII 0 = 널값, \n0000으로 넣어도 됨
			switch((int)(chulsu.avg / 10)) { // chulsu.avg가 실수이므로 정수로 변환
				case 10: case 9: chulsu.grade = 'A'; break;
				case 8: chulsu.grade = 'B'; break;
				case 7: chulsu.grade = 'C'; break;
				case 6: chulsu.grade = 'D'; break;
				default: chulsu.grade = 'F';
			}
			System.out.printf("%10s\t%5d\t%5d\t%5d\t%5d\t%10.1f\t%3c%n",
							chulsu.hakbun, chulsu.kor, chulsu.eng, chulsu.math, 
							chulsu.tot, chulsu.avg, chulsu.grade);
			System.out.print("Again(y/n) ? ");
			y_n = sc.next(); 
			
	} while(y_n.equals("Y") || y_n.equals("y")); // String(문자형)은 equals로 비교
	System.out.println("Program is over..."); 

	}
}