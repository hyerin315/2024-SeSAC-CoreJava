import java.util.Scanner;

public class Input {
	private Employee [] array;
	private Scanner sc, sc1;
	public Input(Employee[] array) {
		this.array = array;
		this.sc = new Scanner(System.in);
		this.sc1 = new Scanner(System.in);
	}
	int input() {
		String i_o = null;
		int count = 0;
		do {
			System.out.print("사원번호 : ");
			String sabun = this.sc.next();
			System.out.print("급 : ");
			int grade = this.sc.nextInt();
			System.out.print("호 : ");
			int ho = this.sc.nextInt();
			System.out.print("수당 : ");
			int bonus = this.sc.nextInt();
			this.array[count] = new Employee(sabun, grade, ho, bonus);
			count++;
			System.out.print("입력 / 출력(I/O) ? ");
			i_o = this.sc1.next().toLowerCase();
		}while(i_o.equals("i") && count < this.array.length);
		return count;
	}
	
}
