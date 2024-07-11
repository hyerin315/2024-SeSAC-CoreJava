
public class Output {

	private Student [] array; // filed
	
	public Output(Student[] array) {
		this.array = array; // 계산이 끝난 array
	}
	
	void output( ) {
		for (Student std : this.array) {// 강화된 for문
			System.out.printf("%-5s\t%7s\t%5d\t%5d\t%5d\t%5d\t%5d\t%8.1f\t%5c%n", 
						std.getHakbun(), std.getName(), std.getKor(), std.getEng(), std.getMat(),
						std.getEdp(), std.getTot(), std.getAvg(), std.getGrade());
		}
	}
}
