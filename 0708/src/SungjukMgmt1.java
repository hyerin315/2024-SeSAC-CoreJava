
public class SungjukMgmt1 {

	public static void main(String[] args) {
		Student[] array = new Student[2]; // array는 시작 주소를 알고 있고, heap에 Student 내의 공간이 생김 = 학생이 들어갈 공간을 만듦

		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		for(int i = 0; i < 2; i++) {
			array[i] = new Student(); // 학생객체 생성
			
			System.out.print("학번 : "); array[i].hakbun = sc.next(); // 이제는 학생의 학번이 array[i]에 들어있음
			System.out.print("국어 : "); array[i].kor = sc.nextInt();			
			System.out.print("영어 : "); array[i].eng = sc.nextInt();
			System.out.print("수학 : "); array[i].math = sc.nextInt();
			
			///array[i].hakbun = hakbun; // 학번 입력하여 넣을 때 에러 : array[i] is null 
			// -> 정상적인 클래스는 new를 쓰지 않으면 사용할 수 없음 & 우리는 Student가 들어갈 공간을 만들었지 Student를 만들지 않았음
			// 객체 배열 : 주소 배열 -  0번째 학생이 들어갈 주소 <= 여기에 학생의 주소에 넣어줘야함 (주소의 주소)
			// 하지만 우리는 지금 학생의 주소를 배열에 넣어주질 않았음 
			// premitive 클래스와의 차이점
			
			array[i].tot = array[i].kor + array[i].eng + array[i].math;
			array[i].avg = array[i].tot / 3.;
			
		}
		for(int i = 0; i < 2; i++) {
			System.out.printf("%10s\t%5d\t%5d\t%5d\t%5d\t%10.1f%n",
					array[i].hakbun, array[i].kor, array[i].eng, 
					array[i].math, array[i].tot, array[i].avg);
		}
		

	}

}
