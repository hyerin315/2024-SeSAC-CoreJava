import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo1 {
	public static void main(String[] args) throws IOException {
		Properties info = new Properties();
		info.load(new FileInputStream(new File("productinfo.properties")));
		System.out.println("나이 = " + info.getProperty("age"));
		System.out.println("거주지 = " + info.getProperty("city"));
	}
}
