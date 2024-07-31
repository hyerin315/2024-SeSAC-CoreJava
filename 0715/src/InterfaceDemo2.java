
public class InterfaceDemo2 {
	public static void main(String[] args) {
		Product pencil = new Product("모니미연필");
		//Product ballpen = pencil;  //주소복사
		//ballpen.clone();
		Product ballpen = pencil.copy();
		System.out.println(ballpen.name);
		pencil.name = "컴퓨터";
		System.out.println(ballpen.name);
	}
}
class Product extends Object implements Cloneable{  //flag interface
	String name;
	public Product(String name) { this.name = name; }
	public Product copy() {
		Product target = null;
		try {
			Object obj = this.clone();
			if(obj instanceof Product) target = (Product)obj;
			else System.out.println("형변환 안됨.");
		} catch (CloneNotSupportedException e) {
			System.out.println("복제 안됨.");
		}
		return target;
	}
	
}