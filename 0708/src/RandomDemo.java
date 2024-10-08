
public class RandomDemo {

	public static void main(String[] args) {
		// 1 ~ 10까지의 랜덤 넘버 추출
		int rand = (int) (Math.random() * 10 + 1); // 강제 형변환을 위해 최대값 *(곱하기), 최소값을 +(더하기)
		System.out.println("rand = " + rand);
		//java.lang.Math 
		
		// switch에서 주의할 점
		// 1. 변수 타입
		// 2. break
		switch (rand) { //switch는 변수 datatype과 break가 중요
			case 1: System.out.println("Bananas"); break;
			case 2: System.out.println("Oranges"); break;
			case 3: System.out.println("Peach"); //switch에서는 Or 처리를 break를 쓰지 않는 것 함
			case 4: System.out.println("Apple"); 
			case 5: System.out.println("Plums"); break;
			case 6: System.out.println("Pineapples"); break;
			case 7: System.out.println("Nuts"); break;
			default : System.out.println("Nuts"); // default는 맨 마지막, 나머지에 해당하므로 break를 쓰지 않아도 됨
												  // 만약, default를 맨 위에 쓸 경우, break를 써야함
		}

	}

}
