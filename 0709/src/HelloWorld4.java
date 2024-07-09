/*
 * 메소드 호출 방법 4)  
 * 다른 클래스에 있는 멤버 변수는 속해있는 클래스를 생성하고, 그 주소로 접근한다.
 */

public class HelloWorld4 {

	public static void main(String[] args) {
		
		Test t = new Test();
		System.out.println(t.str); // str : 클래스 안에서만 찾으므로 클래스 안에 없다면 집주소를 알려줘야함
		
	}

}

class Test {
	String str = "Hello, World"; // member | instance varriable
}