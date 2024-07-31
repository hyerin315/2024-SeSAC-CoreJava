//Property : 속성, 재산, SystemPropertiesAdvaned

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesDemo {
	public static void main(String[] args) {
		Properties infos = System.getProperties();
		Enumeration<Object> enums = infos.keys();
		while(enums.hasMoreElements()) {
			String key = (String)enums.nextElement();
			System.out.println(key + " => " + System.getProperty(key));
		}
	}
}
