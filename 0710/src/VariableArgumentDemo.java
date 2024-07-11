
public class VariableArgumentDemo { 
	// 가변인자(VariableArgument)
	public static void main(String[] args) {
		VariableArgumentDemo vad = new VariableArgumentDemo();
		
		//예제 1
//		int a = 5; 
//		int b = 6; // 추가 
		
		//vad.change(a, b); // 넘어가는/보내는 애(가변적) a = argument : 인자(인수)
				// change의 받는 매개변수가 1개면, 에러남 -> 당연한 결과
				// 자꾸 보내는 애가 달라지면 parameter  갯수의 차이로 에러남
		
		//예제 2
//		int [] array = {3,4,5,6,7};
//		vad.change(array); // 주소만 보냄
		
		//예제 3
		//같은 타입의 가변인자 보낼때
//		int a = 5, b = 7, c = 9;
//		vad.change(a, b, c); // 가변인자 : 값을 마음대로 수정해서 보낼 수 있음
		
		//예제 4
		//다른 타입의 가변인자를 보낼때
		int a = 5; char b = 'B'; boolean c = true;
		double avg = 89.5; String name = "한지민";
		vad.change(a, b, c, avg, name); // argument 인자(인수)
		
	}
	
	//예제 1
//	void change(int a, int b) { // 받는 것은(가변적 X) target = parameter : 매개변수
//	}
	
	//예제 2
//	void change(int [] A) { 
//	}
	
	//예제 3
	// ... 을 통해 가변 인자를 받을 수 있음 (갯수 상관 X)
//	void  change (int ... A) { // A는 배열 (배열 기호만 안썼을 뿐), 다만 ... (배열 아닌 배열, 배열 기호 쓰면 안됨)을 통해 가변적으로 값을 받을 수 있음 -> 받는 개수에 따라 방 루프를 돎
//		for(int su : A) {
//			System.out.println(su);
//		}
//	}
	
	//예제 4
	// 다른 타입의 인자를 받아올 땐, 부모로 받아오면 다 받아올 수 있음 (갯수 상관 X, 타입 상관 X)
	// 상속 개념을 기반으로 받아올 수 있음
	void  change (Object ... A) { // 부모 object(객체)로 자동 형변환
		// Object로 받을 때 - 단점 : 받는 사람 입장에서는 각 인자들의 타입을 알 수 없음 (그래서 나중에 Generic(상속 O, 타입 O)을 사용함) 
		System.out.println(A.length);
	}
	
}
