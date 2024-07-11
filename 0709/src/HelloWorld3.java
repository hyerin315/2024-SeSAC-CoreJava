/*
 * 메소드 호출 방법 3)  
 * 타 클래스에 있는 static 변수는 속해있는 class 이름으로 접근한다.
 */

public class HelloWorld3 {
	
	public static void main(String[] args) {
		
		System.out.println(Demo1.str); // str : 클래스 안에서만 찾으므로 클래스 안에 없다면 집주소를 알려줘야함
		
	}

}

class Demo1 {
	static String str = "Hello, World"; 
}