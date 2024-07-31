
public class WrapperDemo {
	public static void main(String[] args) {
		//before JDK 1.5
//		int su = 5;
//		Integer in = new Integer(su);   //Wrapping, Boxing
//		int another = in.intValue();     //Unwrapping, Unboxing
//		System.out.println(another);
		
		//After JDK 1.5
		int su = 5;
		Integer in = su * 100;     //new Integer(su), Autoboxing
		int another = in;            //in.intValue(), Autounboxing
		System.out.println(another);
	}
}
