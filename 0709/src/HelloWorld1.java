/*
 * 메소드 호출 방법 1) 
 * 동일 클래스에 있는 static 변수는 클래스 이름을 생략할 수 있다.
 */

public class HelloWorld1 {

	// String str = "Hello, World"; // class | static variable 
	static String str = "Hello, World"; // instance | member variable
	// main은 static만 접근 가능 
	
	public static void main(String[] args) {
		// static String str = "Hello, World"; // 지역 변수 : local | stack | temporary | auto variable (사용된 후 자동으로 사라짐)
		System.out.println(str);
	}

}

class Demo {
	static String str = "Python이 대세야!"; // class | static variable : static 변수는 사용시 class 이름으로 접근해야함(집을 짓지 않아도 됨)
	// -> static 변수가 여러 곳에 있을 수 있어서 class 이름으로 접근한다
}