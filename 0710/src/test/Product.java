package test;

public class Product {
	private String name;  // 상품명
	private int count;    // 수량
	private int sell;     // 판매단가
	private int buy;      // 매입단가
	private int delivery; // 운송료
	
	
	// 출력 양식에 맞춰 프린트
	public void print() {
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int array) {
		this.count = array;
	}
	public int getSell() {
		return sell;
	}
	public void setSell(int sell) {
		this.sell = sell;
	}
	public int getBuy() {
		return buy;
	}
	public void setBuy(int buy) {
		this.buy = buy;
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	
	

}
