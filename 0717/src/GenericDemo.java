
public class GenericDemo {
	public static void main(String[] args) {
//		Car carnival = new Car("40_000_000");
//		carnival.setPrice(45_000_000);
//		System.out.println(carnival);  //carnival.toString()
		Car<Integer> carnival = new Car<Integer>(45_000_000);
		System.out.printf("price = %d%n", carnival.getPrice());
		Car<String> matiz = new Car<String>("10000000");
		System.out.printf("price = %s%n", matiz.getPrice());
		Car<Double> sonata = new Car<Double>(45_000_000.0);
		System.out.printf("price = %f%n", sonata.getPrice());
	}
}
class Car<T, U, V>{
	private T price;
	private U name;
	private V maker;

	public Car(T price, U name, V maker) {
		this.price = price;
	}

	public T getPrice() {
		return price;
	}

	public void setPrice(T price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Car [price=%s]", price);
	}
	
	
}