
public class VariableDemo {
	public static void main(String[] args) { //ctrl+ space
		String name; //Variable Deciration 변수 선언 - 이름의 성격을 나타내는 타입이 나와야함
//		name = "한지민"; //Assignment 할당, 한지민 = Literal
//		String email = "aa@aaa.com"; //Initialization 초기화
//		int su = 5;//value 
//		// email, name = stack
//		// 한지민, aa@aaa.com = heap에 저장
//		// su, 5 = stack에 저장 (5는 기본형이므로 stack에 저장)
//		// String = 주소
//		
//		//현대 언어에서 가장 많이 쓰이는 타입 String / Java는 String을 너무 많이 쓰다보니 기본타입처럼 String 변수 선언시 new를 안붙여도 됨
//		//하지만, 결론은 String은 주소임
		
		
//		System.out.printf("숫자 5 = %d\n", 500);
//		System.out.printf("숫자 5 = %o\n", 500);
//		System.out.printf("숫자 5 = %x\n", 500);
//		

//		아래는 에러
//		short a = 5; // 
//		short b = 7;
//		short sum = 5 + 7;
//		System.out.printf("sum = %d\", sum);//앞의 무의미한 부분이 자동으로 짤리고 맨 뒤의 2bite 숫자만 남아 3bite로 자를 수 없기 때문에 에러남
//		
		
//		short a = 5;
//		short b = 7;
//		short sum = 5 + 7;
//		System.out.println(sum); //앞의 무의미한 부분이 자동으로 짤리고 맨 뒤의 2bite 숫자만 남음
		
//		byte a = 5; 
//		byte b = 7;
//		byte sum = 5 + 7;
//		System.out.println(sum); //앞의 무의미한 부분이 자동으로 짤리고 맨 뒤의 2bite 숫자만 남음

//		long a = 32768L;
//		int a = 32768L; //long은 8bite이기 때문에 불가
		float f = 0.1234567890123456789f; // f로 담아줘야 출력 가능
		double d = 0.1234567890123456789;
		
//		System.out.println("f = " + f);
//		System.out.println("d = " + d); //정밀도가 높기 때문에 double을 사용해야함
		
//		System.out.print('A');
//		System.out.print('B');
//		System.out.print('\n');
//		System.out.print('C');
//		System.out.print('D');
//		System.out.print('\b'); //bug : 한칸 뒤로 가서 E가 D를 덮어써야하는데 안됨 
//		System.out.print('E');
		
//		System.out.println(true);
//		System.out.println(false);
//		System.out.println(4 > 5);
//		

//		java.util.Scanner sc = new java.util.Scanner(System.in);
//		String name = "한지민";
		// sc의 사이즈와 name의 타입(성격과 사이즈)이 같다면 왜 앞에 Type을 써줘야할까?
		// Reference type을 왜 써줄까? 32bite CPU일때는 4 bite / 64bite CPU에서 8 bite
		// sc와 name이 같은 타입에 동일한 8bite 임에도 data 타입을 선언해주는 이유는 내가 원하는 번지로부터 내가 가리키는 type이 들어가야함으로 선언해줘야함
		// 내가 가리키는 곳의 시작주소만 가리킴
		
		
//		byte x = 10;
//		byte y = 20;
//		byte sum = x + y; //Error
//		//연산자의 이항 연산자(+,-,...) 무조건 int 사용
//		
		
		short x = 10;
		short y = 20;
		short sum = (short)(x + y); //연산자의 이항 연산자(+,-,...) 무조건 int 사용해야하므로, short로 뽑으려면 강제 변환 해줘야함
		
		
		
				
	}
}
