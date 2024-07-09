

public class MethodDemo4 {

	public static void main(String[] args) { 
		MethodDemo4 md = new MethodDemo4(); 
		int result = md.calcHap(10, 50); // return하는 값을 받아야함
		System.out.println(result);
		
		int result = md.calcHap(1, 100);
		System.out.println(result);
		
		int result = md.calcHap(50, 70);
		System.out.println(result);
	}

	int calcHap(int start, int end){ // member method
		int hap = 0;
		for (int i = 1; i <= end; i++) {
			hap += i;
		}
		return hap; // 나는 계산만 할테니, 출력은 너가해 -> 합이 정수니까 return 타입 맞춰줘야함

	}
	
}



