/*
 * 메소드 호출 방법 2) 
 * 동일 클래스에 있는 멤버변수는 반드시 해당 클래스를 생성해서 그 주소로 접근해야한다.
 */

public class HelloWorld2 {

	String str = "Hello, World"; // member | instance variable : 공유 안함
	
	public static void main(String[] args) {
		
		HelloWorld2 hw = new HelloWorld2(); // 주소로 접근한다
		System.out.println(hw.str);
		
	}

}
