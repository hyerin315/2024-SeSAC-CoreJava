
/*
 * Method를 호출하는 방법 3가지
 * 1) Call(Pass : 객체지향에서는 이렇게 말함) by Name
 * 2) Call(Pass) by Value : 값을 넘기면 value 
 * 3) Call(Pass) by Reference -> Call by Value의 단점을 업그레이드 한 것 : 주소를 넘기면 reference
 */

class Product {
	int price;
}

public class MethodDemo2 {
	public static void main(String[] args) {
		MethodDemo2 md = new MethodDemo2(); 
		Product ballpen = new Product();
		ballpen.price = 100;
		System.out.println("before = " + ballpen.price);
		
		md.change(ballpen); // Call(Pass) by Reference : ballpen은 주소를 갖고 있음
		System.out.println("after = " + ballpen.price);
		
		//int original = 100; // Call(Pass) by Value(값이 프리미티브 변수인 경우) : original과 target은 다른 공간이기 때문에 target을 바꾸더라도 단순 값 복사만 이루어짐
		// -> Call(Pass) by Value의 치명적인 단점 : 값복사가 이루어짐 (안바뀜), 리턴 타입을 하나밖에  못 가져옴
		//md.print(original);
		//System.out.println("original = " + original);
	}
	
	void change (Product pencil) { // pencil = ballpen : 주소 복사(reference 타입이 들어옴)
		pencil.price = 50000;
		}
	
//  Call(Pass) by Valu
//	void print(int target) { //target = original
//		System.out.println("target = " + target);
//		target = 50000;
//		System.out.println("target = " + target); 
//  }
	
}



