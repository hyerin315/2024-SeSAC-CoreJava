/*
 * 다형성
 * 1. 객체 형변환 : 부모-자식(상속) 간에만 가능
 * 	1) 자동 형변환(impicit conversion, promotion)
 * 		* 자식 객체가 부모 객체로 형변환 할 때
 *  2) 강제 형변환 : explict conversion, demotion
 *  	* 부모 객체가 자식 객체로 형변환 하고자 할 때
 *      ** 단, instanceof 연산자가 true를 리턴할 때만
 * 2. Override method
 */
public class PolymorphismDemo {
	public static void main(String[] args) {
		// primitive 타입 간 형변환
//		int su = 5;
//		long lo = su; // 자동 형변환(impicit conversion, promotion)
//		double avg = su; // 자동 형변환 
//		short sh = (short) avg;  // 강제 형변환(explict conversion, demotion)
		
		// 객체 형변환
		Test t = new Test();
		Demo d = new Demo();
//		t = d; // 객체끼리는 형변환이 안됨
//		t = d; // 객체의 형변환 - 자식이 부모로 형변환, boolean만 형변환 불가
//		t = (Test) d; // 이렇게 안해도 됨
//		d = t; // 객체의 형변환 불가 - 부모가 자식으로 형변환
		if(t instanceof Demo) { //instanceof : 참과 거짓 -> 형변환이 가능하면 true, 안되면 false
			d = (Demo) t; // 강제 형변환 - 부모가 자식으로 형변환
		} else {
			System.out.println("안돼");
		}
		
		
	}
}

class Test {}
class Demo extends Test {}