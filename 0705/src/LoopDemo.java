import java.util.Scanner;

public class LoopDemo {

	public static void main(String[] args) {
//		// A ~ Z까지 출력
//		int i = 65; // initialization 
//		
//		for ( ; i <=90; ) {// 조건 나머지는 다 밖으로 빼도 됨
//			System.out.printf("%c\t", (char)i);
//			i++;
//		}
//		System.out.println();
		
//		int i = 90; // initialization 
//		for ( ; i >= 65; ) {// 조건 나머지는 다 밖으로 빼도 됨
//			System.out.printf("%c\t", (char)i);
//			i -= 3; // i = i - 3
//		}
//		System.out.println();
		
		
		// 글자를 5개만 출력한 후 줄바꿈을 해야 한다면
//		int i = 65; // initialization 
//		int count = 1; // initialization
//		
//		for ( ; i <= 90; ) {// 조건 나머지는 다 밖으로 빼도 됨
//			System.out.printf("%c\t", (char)i); // 글자 출력
//			if (count % 5 == 0) { // 5의 배수라면, 5개 마다
//				System.out.println();
//			} else {
//			}
//			i++;
//			count++;
//			
//		}
//		System.out.println();
		
//		//100 안의 4의 배수 갯수 찾기
//		int count = 0;
//		for(int i = 1; i <= 100; i++) {
//			if(i % 4 == 0) {
//				count++;
//			}
//		}
//		System.out.printf("갯수는 %d\n", count);

		
		// 윤년 확인
		// 1. 400년 마다 윤년
		// 2. 연도를 4로 나눠서 딱 떨어지며, 100으로 나눠서 딱 떨어지지 않을 때
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("year : ");
		int year = sc.nextInt(); // 연도를 입력받는다
		
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) { 
			// ||을 |를 하나 쓰면 안되나? 된다! 
			// 하나 쓰면 비트 연산이고, 두개 쓰면 논리연산인데 왜 되는가?
			// 여기서 | 하나만 쓰면 비트연산이고, || 논리연산이 아님!
			// -> | 하나를 쓰면 왼쪽이 참이어도 오른쪽을 넘어가는데, || 두개를 쓰면 왼쪽이 참이 아닐때만 오른쪽으로 넘어가면 되는데, 
			System.out.println("윤년입니다.");
		} else {
			System.out.println("윤년이 아닙니다.");
		}
		
	}

}
