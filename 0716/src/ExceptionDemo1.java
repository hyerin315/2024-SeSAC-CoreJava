
public class ExceptionDemo1 {
	public static void main(String[] args) {
		Car matiz = new Car();
		matiz.name = "대우 마티즈";
		System.out.println(matiz.name);
		matiz = null;
		try {
			System.out.println(matiz.name);
		}//catch(RuntimeException e) {
		//	System.out.println("여기서 잡았음.");
		//}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 범위를 벗어났음.");
			//System.out.println(e.getMessage());  //에러 메세지만
			//System.out.println(e);  //e.toString()   //에러 메시지와 Exception Type
			//e.printStackTrace();
		}catch(NegativeArraySizeException e) {
			System.out.println("배열의 크기는 음수이면 안됩니다.");
		}catch(RuntimeException e) {}
	}
}
