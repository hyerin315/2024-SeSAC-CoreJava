
public class AbstractDemo extends Normal{
	public AbstractDemo(String name) {
		super(name);
	}
	public static void main(String[] args) {
		//Normal normal = new Normal("한지민");
		Normal normal = new AbstractDemo("한지민");
		System.out.println(normal);   //normal.toString()
	}
}

abstract class Normal{
	private String name;

	public Normal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Normal [name=%s]", name);
	}
}