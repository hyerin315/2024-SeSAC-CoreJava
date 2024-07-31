
public class InterfaceDemo1 {
	public static void main(String[] args) {
		Car sonata = new Car("EF소나타", 30_000_000);
		Car matiz = new Car("RedMatiz", 10_000_000);
		//sonata - matiz
		int result = sonata.compareTo(matiz);
		System.out.println(result);
	}
}
class Car implements Comparable<Car>{
	private String name;
	private int price;
	public Car(String name, int price) {
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return String.format("Car [name=%s, price=%s]", name, price);
	}
	@Override
	public int compareTo(Car other) {  //내가 other를 뺀다.
		return this.price - other.price;
	}
	
}