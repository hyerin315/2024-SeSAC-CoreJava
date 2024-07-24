// 상속되지 않는 것
// 1. Overshadow 변수, Override 메소드 상속되지 않는다
// 2. private 멤버는 상속되지 않는다
// 3. static 변수와 static 메소드는 상속되지 않는다 (객체와 별도로 생성되므로 상속과 관련 X)
public class InheritanceDemo2 {
	public static void main(String[] args) {
		//Student jimin = new Student();
		//jimin.
		System.out.println(Person.age); // 자식주소로 접근하는 게 상속
		// 지금 Person과 Student를 생성하지 않은 상태에서 Person.age 접근 가능 (static이기 때문 - static은 어디서나 접근 가능한 놀이터 같음)
	}
}

class Person {
	String name = "한지민";
	static int age = 28; // static은 상속과 관련이 없음
}

class Student extends Person { //name만 상속받음, Person 밖에 있는 것은 상속받지 못함
	
}