/*
public class는 한 파일 안에 하나만 존재

main()은 이 애플리케이션의 시작점 / 동작하기 때문에 함수 (함수 클래스의 method)
main() 코드는 helloworld 밖에 있어서 HelloWorld가 없어도 접근 가능함

아래 코드는 싱글 스레드임
*/



public class HelloWorld {
	public static void main(String [] args){ //public : 아무나 접근 가능하다 / void 무취형 : 아무 값이 없는 것, args : arguments / 자바는 멀티 플랫폼으로 void로 약속함 - OS에 아무것도 넘겨주지 않기 위해 값이 없는 void를 넣음
		java.util.Scanner sc = new java.util.Scanner(System.in);//Java class 이름은 항상 대문자로 시작 / Scanner은 java.util.에 포함되어 있음
		System.out.print("당신 이름은? : ");
		String name = sc.nextLine();
		System.out.printf("귀하의 이름은 %s 입니다. \n",  name);
	}

}
