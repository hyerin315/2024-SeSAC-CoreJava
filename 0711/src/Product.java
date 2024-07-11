
public class Product {
//	String name;
//	int price;
//	String maker;
//	public Product() { // Default constructor
//		this.name = null;
//		this.price = 0;
//		this.maker = null;
//	}
	
	// 생성자 명시하기
	String name;
	int price;
	String maker;
	public Product(String name, int price, String maker) { // 일반 Constructor
		this.name = name;
		this.price = price;
		this.maker = maker;
	}
	
	// 편히 사용하려면 기본 생성자 만들기
	public Product() {} //D efault constructor
	
	// 
}
