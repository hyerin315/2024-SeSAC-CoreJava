/* 
 * Naming Convention
 * 
 * 대문자와 소문자를 구별함
 * 1. PscalCasing : Class, Interface, Enum
 * 2. camelCasing : variable, method
 * 3. Snake_Casing : 대소문자를 구별하지 않을때
 * 4. Kebab-Casing : 중간에 대시를 쓸 때
 * 
 */

/*
 * Method를 호출하는 방법 3가지
 * 1) Call(Pass : 객체지향에서는 이렇게 말함) by Name
 * 2) Call(Pass) by Value : 값을 가져옴
 * 3) Call(Pass) by Reference : 주소가 넘어감
 */

public class MethodDemo {

	public static void main(String[] args) { // main은 할일을 줄이고 할일은 분산하자
		MethodDemo md = new MethodDemo(); 
		md.calcHap(); // Call by Name
	}
	
	// 메소드 (메소드의 필수 3요소 : 이름, 괄호(), 리턴타입 (중괄호는 필수 X))
	
	// 목적
	// 1. 여러번 일이 이루어진다면
	// 2. 특수 목적에만 사용하는 코드라면 아웃소싱 (코드 아웃소싱의 최소 단위가 메소드)
	
	// 구성
	// 1. 선언부(헤더) - 이름, 괄호, 리턴타입
	// 2. 구현부(바디) * 필수 요소 아님
	
	// 종류
	// 1. 클래스 메소드 - static이 붙은 메소드
	// 2. 멤버 메소드 - static이 안붙은 메소드
	
	void calcHap(){ //이름을 통해 언제든지 호출 가능, () 괄호가 있으면 함수, () 괄호가 없으면 변수 / 공통점 : 둘 다 소문자로 시작
	// -> int : 반환 타입 / void : 무취의 아무것도 아닌 타입, 반환타입 (데이터 타입으로 쓰지 않음)
		int hap = 0;
		for (int i = 1; i < 100; i++) {
			hap += i;
	}
	System.out.println("1부터 100까지의 합은 "+ hap + "입니다.");

	}
	
}



