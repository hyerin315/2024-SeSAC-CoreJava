
public class Car {
	public String name; //외부에서 접근 불가
	public int price;
	
	// 기본 생성자 (모든 클래스마다 하나씩 다 존재)
	public Car() {// Car 클래스의 기본 생성자 (자동으로 만들어주기 때문에 명시적으로 적지 않아도 됨)
		// 안적어도 되는 이유는 컴파일러가 자동으로 생성해주기 때문
		// → 그렇기 때문에 name, price를 넣을 수 있는 것
		this.name = null;
		this.price = 0;
	}; 
	
	
	public void setName(String name) { // String name 으로 하면 오류(this 안쓸 때) / String n으로 변경하면 오류 X
//		name = name;  // 멤버변수와 파라미터변수의 이름이 같으면 컴파일러가 구분을 못함(혼동이 생김) 		
//		name = n;     // 에러 안생김
		
		// 1. this. (나의 주소)
		this.name = name; // this는 자동으로 붙여주나, set에서는 this를 무조건 꼭 써야함
		// 나의 주소
		
	}
	public void setPrice(int price) {
//		price  = price;
		this.price = price;
	}
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
	
	// 
	public Car clone() { // 자동차 복제 (주소복사) : 이 집 열쇠를 갖고 있다는 것과 동일
		return this; // 본인의 집을 통째로 넘기는 것 (본인의 주소)
		
	}

}
