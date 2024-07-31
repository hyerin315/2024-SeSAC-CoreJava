
public class ExceptionDemo2 {
	public static void main(String[] args) {
		a();
	}
	static void a() {
		b();
	}
	static void b() {
		try{
			c();
		}catch(ArithmeticException e) {
			System.out.println("여기서 잡았음.");
		}
	}
	static void c() {
		d();
	}
	static void d() {
		System.out.println(5 / 0);
	}
}
