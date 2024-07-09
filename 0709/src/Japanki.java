
public class Japanki {
	
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int[] array = {50000, 10000, 5000, 1000, 500, 100, 10, 5, 1};
		String y_n = null; //지역변수는 자동초기화가 안되므로 자동초기화 해야함
		
		do {
			System.out.print("자판기에 얼마를 내실 건가요? : "); 
			int money = sc.nextInt(); //money 입력값 받기
				
		
			for(int i = 0; i < array.length; i++) { //array.length는 길이를 알려줌
				int mok = money / array[i];
				System.out.println(array[i] +"원권 : " + mok);
				money = money % array[i];
			}
			System.out.print("Again(y/n) ? : ");
			y_n = sc.next().toLowerCase(); // 문장의 소문자화

	} while(y_n.equals("y")); 
	System.out.println("프로그램 종료!");
	sc.close();
	}
}

