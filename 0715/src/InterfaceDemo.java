
public class InterfaceDemo {
	public static void main(String[] args) {
		//Mammal m = new Mammal();
		//5. interface도 추상클래스처럼 인스턴스화가 안된다.
		//Mammal m = new Dog(); m.display();
		//Mammal m1 = new Cat(); m1.display();
		//Mammal.PI = 3.15;  //상수이기 때문에
		Mammal [] array = new Mammal[2];
		array[0] = new Dog();
		array[1] = new Cat();
		for(Mammal m : array)  m.display();
	}
}
//public interface Mammal {
////1. public static final이 생략된 상수만 가질 수 있다.
//double PI = 3.141596;
////2. public abstract이 생략된 추상메소드만을 가질 수 있다.-ㅔ;  
//void display();
//}
//3. interface를 구현시 implements 키워드 사용해야
class Dog implements Mammal{
	//4. interface 추상메소드를 재정의시 반드시 public이어야
	@Override
	public void display() {
		System.out.println("개에 맞게 재정의된 메소드");
	}
}
class Cat implements Mammal{
	@Override
	public void display() {
		System.out.println("고양이에 맞게 재정의된 메소드");
	}
}