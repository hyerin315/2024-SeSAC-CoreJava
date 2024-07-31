
public class LambdaDemo5 {
	public static void main(String[] args) {
		Person2 jimin = new Person2();
		//1st polymorphic parameter를 이용하자.
/*		jimin.greeting(new Say2() {
			@Override
			public int something(int a) {
				System.out.println("I'm Jimin..");
				System.out.println("Nice to meet you.");
				return a * 10;
			}
		});
*/
		//2nd Lambda Expression을 이용하자.
		jimin.greeting((a) -> {
				System.out.println("I'm Jimin..");
				System.out.println("Nice to meet you.");
				return a * 100;
			}
		);
	}
}
@FunctionalInterface
interface Say2{
	int something(int a);
}
class Person2{
	public void greeting(Say2 say) {
		int value = say.something(5);
		System.out.println("value = " + value);
	}
}