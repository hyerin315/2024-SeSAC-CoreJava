
public class AbstractDemo1 extends Normal1{
	public AbstractDemo1(String name) {
		super(name);
	}

	public static void main(String[] args) {
		Normal1 normal = new AbstractDemo1("김지민");
		normal.display();   
	}

	@Override
	public void display() {
		System.out.println(super.getName());
	}
}
abstract class Normal1{
	private String name;   //field

	public Normal1(String name) {  //constructor
		this.name = name;
	}

	public abstract void display();
	
	public String getName() {  //getter
		return name;
	}

	public void setName(String name) {  //setter
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Normal [name=%s]", name);
	}
}