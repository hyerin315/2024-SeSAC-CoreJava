//Heterogeneous Collections : 이종 컬렉션
public class PolymorphismDemo3 {
		public static void main(String[] args) {
//			Dog [] array = new Dog[3];
//			array[0] = new Cat(); // 배열 : 성격, 구조, 크기가 같은 것 -> 같이 않기 때문에 에러남
			
			Mammal [] array = new Mammal[4];
			array[0] = new Dog();
			array[1] = new Cat();
			array[2] = new American();
			array[3] = new Korean();
			
		}
}
