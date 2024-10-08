
public class NestedLoopDemo {

	public static void main(String[] args) {
		//중첩 반복문
		int i = 1;
			
		// 덜 도는 애가 안쪽, 더 도는 애가 바깥쪽
		while(i <= 9 ) { //i 조건
			int dan = 2; //초기화
			while (dan <=9 ) { //dan 조건
				System.out.printf("%d X %d = %d\t", dan, i, dan * i); // %n : 줄 바꿔라
				dan++; //dan 증감식
			}
			System.out.println();
			i++; //버릇처럼 update를 먼저 해줘야 무한루프를 안돌 가능성이 높음
		}
		
	}
}
