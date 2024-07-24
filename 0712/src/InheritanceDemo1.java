// 상속되지 않는 것
// 1. Overshadow 변수, Override 메소드 상속되지 않는다
// 2. private 멤버는 상속되지 않는다
public class InheritanceDemo1 {
	public static void main(String[] args) {
		Frog f = new Frog();
		f.name = "개구리"; // 에러 - private 은 상속되지 않음 (엄연히 다른 클래스이므로 private은 은닉함)
	}
}

class 양서류 {
	private String name;
	int weight;
}

class Frog extends 양서류 {
	
}