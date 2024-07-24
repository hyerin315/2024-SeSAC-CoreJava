// 상속되지 않는 것
// 1. Overshadow 변수, Override 메소드 상속되지 않는다
// 2. private 멤버는 상속되지 않는다
// 3. static 변수와 static 메소드는 상속되지 않는다 (객체와 별도로 생성되므로 상속과 관련 X)
// 4. 부모 생성자는 상속되지 않는다
//    -> 자식 생성자는 부모의 기본 생성자만 호출한다
//    * super() 메소드는 자식 생성자에서 임의로 부모 생성자를 호출할 때 사용한다
//      반드시 생성자 안에서만 사용해야하고, 생성자 안에서 반드시 첫번째에 위치해야한다 (그렇기에 this랑 같이 쓰면 X)
public class InheritanceDemo3 {
	public static void main(String[] args) {
		Sonata sonata = new Sonata("EF Sonata", 30_000_000); // 상속은 부모가 먼저 만들어지고, 그 다음 자식이 만들어짐
		
	}
}

//부모
class Car { // 상속이 되려면 final 클래스가 아니어야함
//final class Car { // final 클래스는 상속이 안됨 = 자손을 만들지 못함
//	String name;
//	int price;
	
//	// 부모의 기본 생성자가 아닌 생성자
//	public Car(String name, int price) {
//		System.out.println("나는 부모의 생성자");
//		this.name = name; this.price = price;
	
	
	String name;
	public Car(String name) {
		this.name = name;
	}
}

//자식
class Sonata extends Car{
//	String name;
//	int price;
	
//	public Sonata() {
//		System.out.println("나는 자식의 생성자");
//	}
	
	// 부모의 기본 생성자가 아닌 다른 생성자 호출 시 
//	public Sonata(String name, int price) {
// 		this.name = name; this.price = price; //오류 : 암식적으로 부모 생성자 안의 것들이 정의되지 않았음 -> 자식생성자는 기본 생성자만 호출 가능한데, 부모생성자에 기본 생성자가 없음
//		super(name, price); 
//	}
	
//	// 부모의 기본 생성자 호출시 
//	public Sonata(String name, int price) { // 기본 생성자만 있을 경우, 오류나지 않음
//	}
	
	
	//supre와 this
	int price;
	
	public Sonata(String name, int price) {
		// 1. 둘 다 쓰면 : 오류
//		this(price);
//		super(name); // super 와 this는 한 번에 같이 쓸 수 없음 -> 둘 다 먼저 나와야하므로
		
		// 2. 오류 안나고 둘 다 쓰려면
		super(name);
		this.price = price;
	}
	
}