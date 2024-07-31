public class StaticDemo1 {
	private int a;   //member variable
	private static int b = print();   //static variable	
	public static void main(String[] args) {
		System.out.println("나는 메인 메소드");
	}
	void display() {   //member method
		
	}
	static int print() {  //static method
		System.out.println("나는 스태틱 메소드");
		return 30_000_000;
	}
}
