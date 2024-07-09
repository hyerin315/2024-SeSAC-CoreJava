/*
 * 메소드 호출 방법 7) 
 * 다른 클래스의 static 메소드는 클래스 이름으로 접근한다.
 */

public class HelloWorld7 {
	public static void main(String[] args) {
		Employee.print();
	}
}
class Employee{
	static void print() { //satic | class method
		System.out.println("Hello, World");
	}
	
}