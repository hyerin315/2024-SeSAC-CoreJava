
public class ArrayDemo2 {

	public static void main(String[] args) {
//		int [] array; //배열 선언 : 배열은 시작 주소를 저장할 참조 변수 -> array는 참조변수로 8바이트 (배열의 데이터 타입과 무관, int[] : int 배열을 받을 참조변수)
		//int[] : 여기서 int는 int 값만 받을 것임 (이때 int 값은 4바이트)
//		array = new int[4]; //배열의 생성
//		array[0] = 5; //할당
//		double [] avg = {89.5}; //초기화
		
		//대괄호의 갯수에 따라 차원을 설정
//		int [][] array; //2차원 배열 선언
		
		
		//1. 2차원 배열 선언 Rectangular Array -> 4행 3열
//		array = new int[4][3]; 
//		array [0][0] = 5; //방법1) 하나씩 할당
		
//		int [][] array = { //방법2) 한번에 할당
//				{ 1,2,3 },
//				{ 4,5,6 },
//				{ 7,8,9 },
//				{ 10,11,12 }
//		};
		
//		int [][] array; //선언
//		array = new int[4][3]; //생성
//		array[0] = new int [] {1,2,3}; // 방법3) 나눠서 할당
//		array[1] = new int [] {4,5,6};
//		array[2] = new int [] {7,8,9};
//		array[3] = new int [] {10,11,12};
		
		
		//2. 4행인데 열이 결정되지 않았을때 Jagged(Ragged) Array -> 4행 ?열
//		array = new int[4][ ]; //
//		double [] avg = {89.5}; //초기화
		
		
		int[][] array; //선언
		array = new int[4][ ]; //생성
		// 생성 후 할당 단계에서 각 방마다 사이즈를 안만들어줘도 됨 -> 자바는 다차원 배열에서 방 개수가 의미가 없다고 생각해서 안넣어도 됨
		array[0] = new int [] {1,2,3,4}; //0층엔 방 4개 -> 0층은 1,2,3의 주소를 갖고 있음
		array[1] = new int [] {5,6}; //1층에 방 2개
		array[2] = new int [] {7};
		array[3] = new int [] {8,9,10,11,12};
		
//		System.out.println(array.length); //4
//		System.out.println(array[0].length); //4
		
		for(int i = 0; i < array.length; i++) {//층  돌기
			for(int j = 0; j < array[i].length; j++) {
				System.out.printf("array[%d][%d] = %d\t", i, j, array[i][j]);
			}
		System.out.println(); //줄바꿈

		}
	}
}
