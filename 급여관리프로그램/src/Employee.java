
public class Employee {
	private String sabun; // 사번
	private int grade; // 급
	private int ho; // 호
	private int bonus; // 수당
	private int money; // 지급액
	private double tax; // 세금
	private long salary; // 차인지급액

	public Employee(String sabun, int grade, int ho, int bonus) {
		this.sabun = sabun;
		this.grade = grade;
		this.ho = ho;
		this.bonus = bonus;
	}

	public String getSabun() {
		return sabun;
	}

	public int getGrade() {
		return grade;
	}

	public int getHo() {
		return ho;
	}

	public int getBonus() {
		return bonus;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return String.format("%-5s\t%3d\t%3d\t%,7d\t%,10d\t%5.0f\t%,10d",
				this.sabun, this.grade, this.ho, this.bonus, this.money, this.tax, this.salary);
	}
	
	public void display() {
		System.out.printf("%s\t%d\t%d\t%d%n", this.sabun, this.grade, this.ho, this.bonus);
	}
}
