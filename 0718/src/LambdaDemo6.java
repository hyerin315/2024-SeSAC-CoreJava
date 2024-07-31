
public class LambdaDemo6 {
	public static void main(String[] args) {
		Person3 jimin = new Person3();
		//1st polymorphic parameter를 이용하자.
/*		jimin.greeting(new Say3() {
			@Override
			public int something(int a, int b) {
				System.out.println("I'm Jimin..");
				System.out.println("Nice to meet you.");
				return a * b;
			}
		});
*/
		//2nd Lambda Expression을 이용하자.
		jimin.greeting((a, b) -> {
				System.out.println("I'm Jimin..");
				System.out.println("Nice to meet you.");
				return a + b;
		});
	}
}
@FunctionalInterface
interface Say3{
	int something(int a, int b);
}
class Person3{
	public void greeting(Say3 say) {
		int value = say.something(5, 10);
		System.out.println("value = " + value);
	}
}