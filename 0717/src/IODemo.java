import java.io.IOException;
import java.io.InputStream;

public class IODemo {
	public static void main(String[] args) {
		System.out.print("글자 한 개를 입력하세요 : ");
		InputStream is = System.in;
		int code = 0;
		try {
			code = is.read();  //ASCII
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("code = " + (char)code);
	}
}
