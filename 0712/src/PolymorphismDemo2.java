// 다형성 : OOP의 핵심
// 다형성에서는 complie 할 때의 타입과, runtime에서의 타입이 다름 (.Net에서는 얼리 타입이라 함)
public class PolymorphismDemo2 {
	public static void main(String[] args) {
		PolymorphismDemo2 pd = new PolymorphismDemo2();
		Mammal m = null; // 부모의 m (컴파일형)
		for(int i = 0; i < 3; i++) {
			int choice = pd.choose();
			switch (choice) {
				// 부모가 자식의 sayThing 으로 접근 -> 자식에 따라 구현부가 다름 (각각의 자식이 부모의 sayThing을 바꿈)ㄹ
				// 접근 주소는 부모
				case 1: m = new Dog(); break; // 부모의 m (런타임형)
				case 2: m = new Cat(); break; 
				case 3: m = new American(); break;
				case 4: m = new Korean(); break;
			}
			m.sayThing();//
		}
	}
	int choose() { //member method
		System.out.println("************Menu************");
		System.out.println("1. Dog");
		System.out.println("2. Cat");
		System.out.println("3. American");
		System.out.println("4. Korean");
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("당신은 어느 종족입니까?(1~4) : ");
		return	sc.nextInt();
	}
}

