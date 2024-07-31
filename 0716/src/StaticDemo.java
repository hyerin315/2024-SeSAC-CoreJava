
public class StaticDemo {
	public static void main(String[] args) {
		Tiger [] array = new Tiger[4];
		for(int i = 0 ; i < array.length ; i++) {
			array[i] = new Tiger();
		}
		for(Tiger t : array)   
			System.out.println("a = " + t.a + ", b = " + Tiger.b);
	}
}
class Tiger{
	int a;
	static int b;
	public Tiger() {
		a++;
		b++;
	}
}