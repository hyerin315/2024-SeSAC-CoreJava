
public class ArrayDemo3 {

	public static void main(String[] args) {
//		//배열의 주소복사 : 변수 2개가 같은 주소를 갖고 있을 때, target과 original은 같은 주소를 가리킴, 좀 덜까다로운 편
//		int [] original! = {3,4,5};
//		int [] target = original; // 같은 메모리 heap에 있는 주소를 두 곳에서 갖고 있음 같은 배열
//		
//		target[0] = 100;
		
		
		// 배열의 값 복사 : 방의 갯수를 따지므로 까다로운 편
		
		// 1) 예시 : 방 갯수가 같을 때
//		int [] original = {3,4,5};
//		int [] target = new int[original.length];
//		target[0] = original[0]; 값 복사
		
		// 2) 예시 : 방 갯수가 다를 때
		int [] original = {3,4,5};
		int [] target = new int[10];
		System.arraycopy(original, 1, target, 8, 2); // '오리지날 배열'의 '어디부터(배열 위치)' 'target 배열'의 '몇 번째 것(배열 위치)'을 '몇 개(복사 갯수)' 가져올거야?
		// 복사하려는 original 배열의 값이 target 방의 크기보다 크면 에러남
				

	}

}
