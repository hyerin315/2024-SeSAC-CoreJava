/*
 * 다형성
 * 1. 객체 형변환 : 부모-자식(상속) 간에만 가능
 * 	1) 자동 형변환(impicit conversion, promotion)
 * 		* 자식 객체가 부모 객체로 형변환 할 때
 *  2) 강제 형변환 : explict conversion, demotion
 *  	* 부모 객체가 자식 객체로 형변환 하고자 할 때
 *      ** 단, instanceof 연산자가 true를 리턴할 때만
 * 2. Override method
 *
 *
 *
 * Child : String
 * Parent : Object
 */

//강제 형변환
public class PolymorphismDemo1 {
	public static void main(String[] args) {
//		String str = "Hello, World";
//		Object original = str; // 자식이 부모형으로 자동 형변환
//		
////		if (original instanceof String) {		
////		System.out.println("된다");
////		} else System.out.println("안된다"); // 값 : 된다
//		String target = (String) original; // 부모님이 자식으로 강제 형변환
//		System.out.println(target); // 값 : Hello, World
		
//		Child younghee = new Child();
//		younghee.display();
		
		Parent jimin = new Parent();
		Child younghee = new Child();
		jimin = younghee; //자동 형변환
		jimin.display(); //값 : 나는 자식 메소드 -> 부모님의 주소로 자식을 사용하는 것 (다형성)
		
	}
}

class Parent{
	public void display() {
		System.out.println("나는 부모 메소드");
	}
}
class Child extends Parent{
	@Override
	public void display() { //오버라이드 : 선언부(이름, 리턴타입, 파라미터)가 같으나 바디(구현부)가 다른 것
		System.out.println("나는 자식 메소드");
	}
}