// 클래스 설계
// 클래스를 설계하는 사람과 쓰는 사람은 다른 생각을 할 수 있음


public class Employee {
	String sabun; 
	double salary;
	
	
//	public Employee() {
//		this.sabun = null;
//		this.salary = 0.0;
//	}
	
	//에러
//	public Employee() {
//		new Employee("임시사번", 10_000_000);
//	}
	
	//에러
//	public Employee() {
//      System.out.prinln(); // this 앞에 다른 게 왔기 때문에 에러
//		new Employee("임시사번", 10_000_000);
//	}
	
	//해결
//	public Employee() {
//		this("임시사번", 10_000_000); // this로 나의 또 다른 생성자를 호출
//	}
	
//	public Employee(String sabun) {
//		this.sabun = sabun;
//	}
//	public Employee(double salary) {
//		this.salary = salary;
//	}
//	public Employee(String sabun, double salary) {
//		this.sabun = sabun;
//		this.salary = salary;
//	}
	
	
	public Employee() {
		this("UmsettedSabun", 10_000_000);
	}
	public Employee(String sabun) {
		this(sabun, 10_000_000);
	}
	public Employee(double salary) {
		this("UmsettedSabun", salary);
	}
	public Employee(String sabun, double salary) {
		this.sabun = sabun;
		this.salary = salary;
	}
	
}
