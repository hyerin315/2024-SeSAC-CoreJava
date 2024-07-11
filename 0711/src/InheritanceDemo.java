
public class InheritanceDemo {

	public static void main(String[] args) {
		Dog dog = new Dog();
		//dog.새끼를낳다(); // 부모님의 새끼를낳다()가 포함되어 있으므로 사용 가능
		
		Cat cat = new Cat();
		cat.젖을먹이다(); // 부모님의 메소드를 내 것 처럼 사용 가능
	
		// Overshadow 변수 : 부모님의 변수와 자식의 변수가 같은 것을 Overshadow 변수라 함
		// - 상속이 안됨
		// -> dog(자식)을 통해 mammal(부모)를 접근하는데, dog의 주소로 갔을 때 변수가 있기 때문에 mammal 에 갈 필요가 없음
		System.out.println(dog.name); // 값 : 나는 개다
		
		dog.print(); // Override 메소드로 상속이 안됨
	}

}
