/*
 * this 용법
 * 
 * 1. this. (나의 주소로부터, 주소의) : 객체 자기 자신의 주소를 가리키는 지시대명사 (대명사) ex. VD.net에서는 me로 처리함
 * 2. this (나) : 객체 자체 (결국, 메모리 힙에 만들어지는 주소)
 * 3. this() (나의 생성자)
 */

public class ThisDemo {
	public static void main(String[] args) {
		Car sonata = new Car();
		sonata.setName("현대소나타");
		sonata.setPrice(30_000_000);
		System.out.println("이름 = " + sonata.getName());
		
		// 2. this (나)
		Car matiz = sonata.clone(); // sonata의 주소가 복사된 것
		System.out.println(matiz.getName()); // 결과 : 현대 소나타
			
	}

}
