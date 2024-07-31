public class AnonymousClassDemo1 {
	public static void main(String[] args) {
		Birds bi = new Birds() {
			@Override
			public void fly() {
				System.out.println("하늘을 날다.");
			}
			@Override
			public void roam() {
				System.out.println("여기저기 배회하다.");
			}
		};
		bi.fly();    bi.roam();
	}
}
interface Birds{
	void fly();
	void roam();
}