
// 초기화 방법
// 1. 직접 초기화 하는 방법
// 2. 생성자로 초기화 하는 방법
// 3. 초기화 블록으로 하는 방법 
//    단점 : 초기화 블록은 생성자 대신 역할을 하나 이름이 없으므로 바꿀 방법이 없음 (이름이 없어서 호출이 안되기 때문)


public class InitializationBlock {
	private double weight; // member variable
	private char grade;
	{
		this.weight = 100.0; this.grade = 'F'; // 순서 2. 두번째 호출
		System.out.println("나는 초기화 블록");
	}; // 초기화 블록 : 생성자보다 먼저 실행, 객체를 실행할 때마다 딱 한 번 자동 생성된다
	
	public InitializationBlock() { // default constructor's overriding
		System.out.println("나는 생성자");
//		this.weight = 62.4; // 순서 3. 마지막 호출
//		this.grade = 'C';
	}
	
	public static void main(String[] args) {
		InitializationBlock jimin = new InitializationBlock(); // 순서 1. 가장 먼저 호출
		System.out.println(jimin.weight + "kg"); 
		System.out.println(jimin.grade);
	}
}
