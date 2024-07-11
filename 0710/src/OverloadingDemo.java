
public class OverloadingDemo {

	public static void main(String[] args) {

	}
	
	// Method Overloading
	// * 오버로딩 조건 
	// 1. 이름이 같아야한다
	// 2. 매개변수의 타입 / 개수 / 순서 등이 달라야한다 (메소드의 리턴타입은 상관 X)
	void change() {}
	void change(int a) {}
	void change(short b, String name) {}
	void change(double name, int c) {}

}
