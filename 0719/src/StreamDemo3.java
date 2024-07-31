/*
 * 중간연산 : filter(), map()
 * 최종연산 : count(), sum(), max(), min(), average(), reduce(), forEach()
 */
//filter(조건) : 중간연산
//map() : 중간연산

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo3 {
	public static void main(String[] args) {
		String [] array = {"abc", "Hello", "Hi~", "Java Language"};
		Stream<String> sStream = Stream.of(array);  //생성
		sStream.filter(str -> str.length() >= 5).forEach(s -> System.out.print(s + "\t"));
		System.out.println();
		List<Customer> list = new ArrayList<Customer>();
		Customer c1 = new Customer("한지민", 28);   list.add(c1);
		Customer c2 = new Customer("김지민", 38);   list.add(c2);   
		Customer c3 = new Customer("박지민", 48);   list.add(c3);
		Customer c4 = new Customer("홍지민", 58);   list.add(c4);
		Stream<Customer> customerList = list.stream();  //생성
		customerList.map(c -> c.getAge()).forEach(s -> System.out.println(s));
	}
}
class Customer{
	private String name;
	private int age;
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}