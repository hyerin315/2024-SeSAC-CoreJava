
public class SungjuckMgmt {

	public static void main(String[] args) { // member method
		SungjuckMgmt d = new SungjuckMgmt();
		int money = 100;
		String name =  "한지민";
		System.out.printf("Before money = %d, name = %s%n", money, name); // 한지민
		d.change(money, name);
		System.out.printf("After money = %d, name = %s%n", money, name); // 한지민 (그대로, 변경 안됨)
		// String은 레퍼런스 타입이나 String 자체가 바뀌지 않는 불변의 법칙을 갖고 있으므로 바뀌지 않음
		// String buffer, String builder를 사용해야만 가변으로 사용 가능
	}
	void change(int su, String str) { // Call by value
		su *= 5;
		str = "김지민";
		System.out.printf("In change() su = %d, str = %s%n", su, str); // 김지민
	}

}
