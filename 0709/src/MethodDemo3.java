
public class MethodDemo3 {
	public static void main(String[] args) {
		MethodDemo3 md = new MethodDemo3();
		md.print(); 
	}
//	int print() { // member method
//  double print() {
	String print() {
	// 리턴타입
    // * 특징
    // 1. 리턴타입과 리턴은 같아야함
    // 2. 리턴이 이후, 실행되면 도달되지 않음 (에러남)
	//    -> 조건문 안에 선언되는 건 해당되지 않음
    	
	// * 종류
    // 무치형 리턴타입(void) : 복귀할 때 아무것도 안가져간다
	// 정수형 리턴타입(int..) : 숫자를 가져간다 (리턴타입과 리턴은 같아야함)
	// 실수형 리턴타입(int..) : 실수를 가져간다 (리턴타입과 리턴은 같아야함) -> 자동 형변환으로 return 0을 리턴하면 자동으로 형변환 됨
		
		int su = 5;
		System.out.println("Hello");
		if (su % 2 == 0) return "aaaa";
		else {
			System.out.println("Word");
			return "bbb";
		}
		
		//System.out.println("Hello, World");
		// return 0; //정수형 리턴타입
	}
}
