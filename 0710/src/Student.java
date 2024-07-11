//순서
//필드 먼저 + 메소드는 뒤에

//캡슐화
public class Student { // 캡슐화되지 않은 변수
	//0709에서는 Student 안의 학번 이름 등등을 접근할 수 없음
	//public(완전 공개), private(class가 다르면 사용 불가, 숨김(은닉), 외부에서는 있는지 없는지 생성유무도 확인 못함)을 지정하지 않았을 때 defalut(라이브러리 단위 공개)가 들어갔기 때문ㅇ
	private String hakbun, name;
	private int kor;
	private int eng;
	private int math;
	private int tot; //총점
	private double avg;
	private char grade;
	
	
	// print를 student가 직접하게 만들기
	public void print() {
		System.out.printf("%-10s%5d%5d%5d%5d%7.1f%3c%n", hakbun, kor, eng, math, tot, avg, grade);
	}

	
	
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
		
	
	
}
