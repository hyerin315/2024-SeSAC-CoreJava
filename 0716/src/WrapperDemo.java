
public class WrapperDemo {
	public static void main(String[] args) {
		//int su = 5;   //stack에 있는 5
		//Integer in = new Integer(su);  //Wrapping, Boxing //Heap에 있는 5
		//int another = Integer.    //Unwrapping, unboxing
		int su = 5;
		Integer in = su * 100;  //Autoboxing
		int another = in;     //Autounboxing
		System.out.println(another);
		
		
	}
}
