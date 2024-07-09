
public class ArrayDemo {

	public static void main(String[] args) {
		
		int [] array = new int[4]; // 내가 배열을 만들면 값이 자동으로 들어가 있음 (자동으로 힙에 만들어진 애들은 자동으로 0으로 초기화 됨)
		// double : 0.0으로 자동 초기화 됨 p205
		
		
		for (int i = 0; i < 4; i++) {
			System.out.printf("array[%d] = %s\n", i, array[i] ) ;
		}

	}

}
