
public class ArrayDemo {

	public static void main(String[] args) {
//		int [] age; // 변수 선언(declaration) : 컴퓨터에 4바이트의 메모리 필요하다고 선언
//		// 대괄호를 적으면 8바이트 : age는 값이 아닌 주소를 저장할 운명이 됨, 배열 괄호는 앞뒤 상관 없지만 읽는 방법이 int 배열 age에 맞춰 중간에 삽입
//		// 대괄호 적으면 8바이트인데 int를 적는 이유 : 오직 int 배열만 받아야하므로
//		// [] 대괄호 개수에 따라 1차원, 다차원 분류
//		
//		String name = "한지민"; // 선언(initialization) : 선언과 할당을 한 번에 하는 것
//		age = 28; // 할당(asignment)
//		
//		
//		
//		age = new int[4]; // heap에 올리기 위해 new 사용, 참조형이므로 creation 이라는 과정을 거쳐야함
//		// 방 갯수를 적으면 이 시작 주소를 age에 넘겨줌
//		age[0] = 6; age[1] = 7; age[2] = 8; age[3] = 9; // 할당(assignment) : 한 칸의 사이즈가 4바이트
//		
		// 초기화 방법
		// 1. 첫번째 방법
		char[] array = null;
		array = new char[] {'a', 'b', 'c', 'd'} ; 
		
		// 2. 두번째 방법
		// 한 번에 초기화 initialization 
		char[] array = {'a', 'b', 'c', 'd'}; //선언과 동시에 초기화
		// 단점 - 따로 분리하여 다른 라인에 적을 수 없음
		// ex)
		// char [] array = null;
		// array = {'a', 'b', 'c', 'd'} // 컴파일 오류 : array는 한 줄에 써야함
		
		
		
//		//배열은 자료 구조
//		int [] array; //declaration
//		array[0] = 5; array[1] = 1; array[2] = 7; array[3] = 8; //assignment //컴퓨터의 인덱스는 0부터 시작
//		
//		for(int i = 0; i < 4; i++) {// 몇번 반복할지 아니까 for를 사용
//			System.out.println("array[" + i + "] = array[i]", array[i] + "\t");
//		}
//		System.out.println();
		
		
		String[] array = {"Hello", "World", "Good", "Java", "A"}; //initialization
		//array가 주소를 알고 있음
		array[3] = "Python"; //인덱스를 활용하면 방의 해당하는 것을 바꿀 수 있음
		for (int i = 0 ; i < 5 ; i++) {
			System.out.println("arry[" + i + "] =" + array[i]);
		// 앞에서부터 얼마나 떨어져있는가로 방의 위치를 찾아감

		}
	}

}