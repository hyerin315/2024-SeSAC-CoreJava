
/*
 * Method를 호출하는 방법 3가지
 * 1) Call(Pass : 객체지향에서는 이렇게 말함) by Name
 * 2) Call(Pass) by Value
 * 3) Call(Pass) by Reference
 */

public class MethodDemo1 {
	public static void main(String[] args) { // main은 할일을 줄이고 할일은 분산하자
		MethodDemo1 md = new MethodDemo1(); 
		md.calcHap(10, 50); // start 값부터 시작 
		md.calcHap(1, 100);
		md.calcHap(50, 70);
	}

	void calcHap(int start, int end){ // member method / Call(Pass) by Value : 시작과 끝값을 정한 상태
		int hap = 0;
		for (int i = 1; i <= end; i++) {
			hap += i;
	}
	System.out.println(start + "부터" + end + "까지의 합은 "+ hap + "입니다.");

	}
	
}



