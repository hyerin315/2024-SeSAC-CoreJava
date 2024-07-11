
public class EncapDemo {

	public static void main(String[] args) {
		Car sonata = new Car();
//		sonata.name = "현대 소나타"; // 접근 불가
//		sonata.price = 30_000_000;
		
		// 오픈된 메소드를 통해 private 변수 접근
//		sonata.set("현대 소나타", 30_000_000); // 접근 가능
//		System.out.printf("이름 = %s, 가격 = %d%n", sonata.name, sonata.price); //접근 불가
		
		// 메소드 분리
//		System.out.printf("이름 = %s%n", sonata.getName(), sonata.getPrice() ); 
		
		sonata.setName("현대소나타");
		sonata.setPrice(30_000_000);
		System.out.printf("이름 = %s%n", sonata.getName(), sonata.getPrice());
		
	}

}

//캡슐화 (코드가 길어짐)
//필드는 데이터를 보호하기위해 프라이빗으로, 퍼블릭 메소드는 데이터를 접근하려고 존재
class Car {
//	String name; //캡슐화가 안되어 있으면 main에서 언제든지 접근 가능
//	int price;
	
	// 캡슐화
	private String name;
	private int price;
	
	//private을 접근가능하게 하는 메소드
//	public void set(String n, int p) {
//		name = n;
//		price = p;
//	}

	
	//메소드 분리
//	public String getName() { // Call of Value 단점 - 리턴은 1개밖에 못함
//		return name;
//	}
//	public int getPrice() {
//		return price; 
//	}
	
//	//메소드 분리 2
//	public void setName(String n) { name = n; }
//	public void setPrice(int p) { price = p; }
//	public String getName() { return name; }
//	public int getPrice() { return price; }

	// 툴을 통한 자동화	(오른쪽 버튼 + source + Generate getter an setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		// 지시대명사(jvm만 알고 있음) : this (나의) - 주소
		// 지역변수는 name이고, 멤버변수는 this name이야 -> 이렇게 씀
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}