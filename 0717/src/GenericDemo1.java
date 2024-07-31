import java.util.ArrayList;
import java.util.List;

public class GenericDemo1 {
	public static void main(String[] args) {
		///Object obj = "Hello";
		//java.util.Vector<Object> v1 = new java.util.Vector<String>();
		//java.util.Vector v1 = new java.util.Vector();  //raw type
//		Vector<?> v1 = new Vector<?>();  //wildcard type
//		v1.add(5);
//		Product<Integer> pencil = new Product<Integer>(1000);
//		Product<Double> ballpen = new Product<Double>(100.0);
//		Product<Object> obj = new Product<Object>(new Car());
		//Car<?> car = new Car<Integer>(1000);
		//Car<Object> car1 = new Car<Integer>(1000);
		//Object obj = car.getPrice();
		//Car<? extends Number> car1 = new Car<Integer>(100);
		
		//Car<? super Number> car2 = new Car<Object>(1000);
		//super인 경우에는 실체형을 따라가고,
		//extends인 경우에는 선언형을 따라간다.
		//?는 Object형을 따라간다.
		
		List<Car> list = new ArrayList<Car>();
		
 	}
}
