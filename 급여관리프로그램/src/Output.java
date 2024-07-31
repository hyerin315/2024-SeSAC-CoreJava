
public class Output {
	private Employee [] array;
	private int count;

	public Output(Employee[] array, int count) {
		this.array = array;
		this.count = count;
	}
	void output() {
		this.printLabel();
		for(int i = 0 ; i < count ; i++) {
			System.out.println(this.array[i]);
		}
		
		System.out.println();
		System.out.println("입력데이터 출력");
		for(int i = 0 ; i < this.count; i++) {
			this.array[i].display();
		}
	}
	void printLabel() {
		System.out.println("                                <<급여 관리 프로그램>>");
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("사번\t급수\t  호\t  수당\t    지급액\t  세금\t   차인지급액");
		System.out.println("-------------------------------------------------------------------------------------------------");
	}
}
