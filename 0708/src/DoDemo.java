
public class DoDemo {

	public static void main(String[] args) {
		// 4! = 4 * 3 * 2 * 1
		
		
		// for문으로 무한루프를 돌 경우, 무한루프에 대한 부담이 생김 
//		java.util.Scanner sc = new java.util.Scanner(System.in);
//		System.out.print("몇 Factorial? : ");
//		
//		for(; ;) { // for(; true; ;) : 무한루프
//			int su = sc.nextInt();
//			int answer = 1;
//			for (int i = su ; i > 0 ; i--) {
//				answer *= i; 
//			}
//			System.out.printf("%d!= %d", su, answer);	
//		}
		
		
		// 중간에 한 번 물어본 후 루프를 돌기 위해 do문 사용
		java.util.Scanner sc = new java.util.Scanner(System.in);
		String y_n = null; //y_n은 주소를 가리켜야 하는데, 초기화 시켜야 하므로 null로 초기화 (아무것도 참조하지 않는 null 번지를 가리킴)
		
		do {
			System.out.print("몇 Factorial? : ");
			int su = sc.nextInt(); // nextChar()은 없음
			int answer = 1;
			for (int i = su ; i > 0 ; i--) {
				answer *= i;
			}
			System.out.printf("%d!= %d \n", su, answer);
			System.out.print("Again(y/n) ? : ");
			//String y_n = sc.next();
			y_n = sc.next();
		} while (y_n.equals("Y") || y_n.equals("y")); //y_n : 중괄호 있는 변순는 다 지역변수이나 y_n이 중괄호를 벗어나면 자동 소멸됨. 그렇기에 이곳에서 y_n은 인식이 어려움 
	}
}
