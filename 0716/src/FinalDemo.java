
public class FinalDemo {
	public static void main(String[] args) {
		Parent bumo = new Jasik();    bumo.display();
	}
}
class Parent{
	public final void display() {
		System.out.println("나는 부모의 메소드");
	}
}
class Jasik extends Parent{
//	@Override
//	public void display() {
//		System.out.println("나는 자식의 메소드");
//	}
}