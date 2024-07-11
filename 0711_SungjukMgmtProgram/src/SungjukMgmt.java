import java.io.FileNotFoundException;

public class SungjukMgmt {
	public static void main(String[] args) throws FileNotFoundException { // main은 원래 맨 마지막에 만들어얌
		// throws 는 JVM에 던짐
		Student [] array = new Student[12]; // 학생의 주소와 저장될 수첩(12페이지)
		
		Input input = new Input(array); // 데이터 넣기 : 데이터를 넣으면 기본 생성자가 아니므로 따로 만들어야함
		input.input();
		
		Calc calc = new Calc(array); // 계산
		calc.calc();
		
		Output output = new Output(array); // 출력
		output.output();
		
		System.out.println("Program is over...");
	}
}
