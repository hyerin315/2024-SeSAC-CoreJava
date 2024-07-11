
public class Input {
	void input(Student std) { //member method
		java.util.Scanner sc = new java.util.Scanner(System.in);
//		System.out.print("학번 : "); std.getHakbun = sc.next();
//		System.out.print("국어 : "); std. = sc.nextInt();
//		System.out.print("영어 : "); std. = sc.nextInt();
//		System.out.print("수학 : "); std. = sc.nextInt();

		//private에 접근에 못해서 우회해서 접근
		System.out.print("학번 : "); 
		String hakbun = sc.next();
		std.setHakbun(hakbun);
		
		System.out.print("국어 : ");
		std.setKor(sc.nextInt()); // 단축
		
		System.out.print("영어 : "); 
		std.setEng(sc.nextInt());
	
		System.out.print("수학 : "); 
		std.setMath(sc.nextInt());
		
	}
}
