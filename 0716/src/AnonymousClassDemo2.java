
public class AnonymousClassDemo2 {
	public static void main(String[] args) {
		AnonymousClassDemo2 acd = new AnonymousClassDemo2();
		//Dog dog = new Dog();   
		//acd.display(dog);
		acd.display(new Mammal() {
			@Override
			public void sound() {
				System.out.println("멍멍멍멍");
			}
		});
	}
	void display(Mammal m) {
		m.sound();
	}
}

interface Mammal{
	void sound();
}
//class Dog implements Mammal{
//	@Override
//	public void sound() {
//		System.out.println("멍멍멍멍");
//	}
//}