
public class ForDemo {
	public static void main(String[] args) {
		int count = 0, line = 1;
		int i = 65;
		
		
		//for, while은 초기 값이 조건을 맞는다면 돌림
//		for(; i <=90;) {
//			if(line % 2 == 0) System.out.print((char)(i + 32) + "\t"); // 소문자 출력
//			else System.out.print((char)(i) + "\t"); // 대문자 출력
//			count++;
//			if (count % 5 == 0) {
//				System.out.println(); line++;
//			}
//			i++; //증감식
//		}
//		
		//while은 초기화 과정은 밖으로 빼고 while()안에 조건문을 입력함
		while (i <=90){ 
			if(line % 2 == 0) System.out.print((char)(i + 32) + "\t"); // 소문자 출력
			else System.out.print((char)(i) + "\t"); // 대문자 출력
			count++;
			if (count % 5 == 0) {
				System.out.println(); line++;
			}
			i++; //증감식
		}
		
	}
}
