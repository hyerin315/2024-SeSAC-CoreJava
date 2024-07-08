//문제 1.
//초를 입력했을 때 시간과 초로 나타내게 해라

public class Test1 {

	public static void main(String[] args) {
		// 1) 정수로 입력 값 받기
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("값 입력(초단위) : ");
		//String num = sc.nextLine();
		//int time = Integer.parseInt(num);
		int time = sc.nextInt();
		
		// 2) 시와 초를 계산하기
		int hours = time / 3600;
		int minutes = time % 3600 / 60;
		int seconds = time - 3600;
		seconds = seconds % 3600 % 60;
		
		// 3) 출력하기
		System.out.printf("%d초는 %d시간 %d분 %d초 입니다.", time, hours, minutes, seconds);
		
		// 4) 종료하기
		sc.close();
	}

}
