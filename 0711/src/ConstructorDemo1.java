
public class ConstructorDemo1 { // 생성자 데모
	private void main(String[] args) {
		MyDate birthday = new MyDate();
		System.out.println(birthday.year);
	}
}
class MyDate {
	int year, month, day;
	
	// 오버라이딩(재정의) 
	// 기본적으로 제공되는 생성자의 초기값을 목적에 맞게 재정의하는 것
	// = 이미 있는 것을 재정의 하는 것 (만들어진 후에 수정해야함)
	public MyDate() { // Default constructor's overriding
//		this.year = 0; // 정수이기 때문에 0
//		this.month = 0;
//		this.day = 0;
		
		this.year = 2024; // 정수이기 때문에 0
		this.month = 7;
		this.day = 11;
	}
}
