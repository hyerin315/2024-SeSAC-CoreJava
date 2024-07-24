// 상속되지 않는 것
// 1. Overshadow 변수, Override 메소드 상속되지 않는다
public class InheritanceDemo {

	public static void main(String[] args) {
		Mammal m = new Mammal();
		m.display();

//		Horse h = new Horse(); // 자식 주소로 부모님에게 접근
//		h.display();
		
		// Override
		Horse h = new Horse();
//		h.display(); // 오버라이드 했을 경우, 자식 주소에 있는 것을 반환함, 오버라이드는 상속되지 X
		
		// 할아버지의 것을 재정의하기 (toString)
		System.out.println(h.toString()); // 값 : Horse@28a418fc -> JVM에 말이 올라온 주소(16진수)
		
	}

}


//class Mammal extends Object{ //모든 객체, 모든 클래스는 Object의 자손 (Object 생략 가능), 그렇기 때문에 .을 헀을 때 내가 만들지 않은 다른 메소드도 많이 뜨는 것
//	public void display() {
//		System.out.println("나는 포유류");
//	}
//	
//}
//
//class Horse extends Mammal {
//	@Override //안써도 되지만 해주면 컴파일러가 인식함
//	public String toString() { // 할아버지인 Object를 재정의(Override)
//		return "나는 제주 말입니다.";
//	}
//	
//	@Override // 어노테이션 : 컴파일러에게 지시사항을 알려주는 것 (일부러 재정의한 사실을 알려줌)
//	public void display() { // 오버라이드 메소드 : 메소드의 이름, 타입 등 선언부는 모두 동일하지만 내부 구현체(바디)만 수정한 것 
//							// -> 부모의 것이 똑같이 상속되지 X (선언부만 사용하고 나의 재산(구현부)을 사용하는 것)
//		//System.out.println("나는 제주 말이야.");
//		
//		//부모님의 display를 호출하고 싶을때
//		super.display(); //super : 부모님 것
//		
//		//나와 부모님의 것 모두 호출하고 싶을 때
//		super.display();
//		System.out.println("나는 제주 말이야.");
//	}
//	
//}