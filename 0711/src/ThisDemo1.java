// 클래스 사용

// 오버로딩
// this() : 디스 메소드
// 
// 주의점
// 1. 꼭 생성자 안에서만 써야함. 다른 곳에서 쓰지 못함
// 2. this 메소드는 생성자의 첫번째에 와야함 (꼭 첫번째 줄에 와야함)
//  

public class ThisDemo1 {
	public static void main(String[] args) {
		Employee chulsu = new Employee();
//		System.out.printf("%.1f", chulsu.salary); // 값 : null / 0
		// -> new를 2번해서
		//    철수가 알고 있는 번지와 Employee (){} 기본생성자에서 new를 하여 번지가 다름
		
		// this를 사용해서 해결했을 때
		// 철수의 다른 생성자(Employee)를 호출함
		System.out.printf("%.1f", chulsu.salary); // 값 1000000.0
		
	}
}
