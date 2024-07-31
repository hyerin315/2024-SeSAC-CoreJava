
public class SalaryMgmt {
	public static void main(String[] args) {
		Employee [] array = new Employee[5];
		Input input = new Input(array);  
		int count = input.input();
		Calc calc = new Calc(array, count);    
		calc.calc();
		Output output = new Output(array, count);   
		output.output();
		System.out.println("Program is over...");
	}
}
