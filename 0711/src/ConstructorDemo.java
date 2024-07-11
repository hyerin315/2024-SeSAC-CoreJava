import java.util.jar.Attributes.Name;

public class ConstructorDemo {
	public static void main(String[] args) {
//		java.util.Scanner sc = new java.util.Scanner(); ()괄호 안에 기본 생성자가 없으므로 에러남
//		// 기본 생성자 (모든 클래스마다 하나씩 다 존재, 태생적으로 메소드 오버로딩을 해야함)
//		Car sonata = new Car(); // new 호출시 생성자(new)는 타입별로 초기화
//		// Car() 클래스에 없는 데도 사용 가능한 이유
//		// : 컴파일러가 자동으로 생성해주기 때문
//		//   → 그렇기 때문에 name, price를 넣을 수 있는 것
//		
//		System.out.println(sonata.name); // 값 null
//		System.out.println(sonata.price); // 값 0
		
		
		Product pencil = 
				new Product("모나미 연필", 1000, "모나미社"); // 순서 바뀌면 X, 타입도 같아야함
		Product computer =
				new Product("노트북", 25_000_000, "LG Gram");				
		Product tv =
				new Product("텔레비전", 30_000_000, "삼성전자");
		
		// 주의할 점
//		Product p = new Product(); // 에러남
		// 명시적으로 생성자를 만들면 클래스 안에는 생성자가 하나 등록 되었기 때문
		// 입맛대로 사용하려면 기본생성자를 임의로 만들어줘야함
		
		//생성자가 필요한 이유 = 필드 초기화
		//기본 값 초기화 -> 자동으로 만들어어줌
		//원하는대로 클래스 안에 명시하면, 클래스 안의 생성자는 하나이므로 불가
		
		
	}
}