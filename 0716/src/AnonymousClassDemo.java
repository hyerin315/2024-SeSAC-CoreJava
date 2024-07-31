public class AnonymousClassDemo {
	public static void main(String[] args) {
//		Canine ca = new Dog();
//		ca.roam();
//		ca.bark();
		Canine ca = new Canine() {
			@Override
			void bark() {
				System.out.println("우르렁 짖다.");
			}
			void display() {
				System.out.println("메소드");
			}
		};
		ca.bark();
		ca.roam();
		//ca.display();
	}
}
abstract class Canine{
	abstract void bark();
	void roam() {
		System.out.println("여기저기 배회하다.");
	}
}
//class Dog extends Canine{
//	void bark() {
//		System.out.println("우르렁 짖다.");
//	}
//}