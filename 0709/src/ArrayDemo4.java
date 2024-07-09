
public class ArrayDemo4 {

	public static void main(String[] args) {
		double [] array = {3.14, 89.5, 182.5, 69.2};
//		for(int i = 0; i < array.length; i++) { // 시작과 끝이 분명하고, 몇번 반복할지 알 때 for를 씀
//			System.out.printf("%.2f%n", array[i]);
//		}
		
		//Enhanced For : 이미 만들어져 있는 배열과 컬렉션에만 사용 (ex. 구구단 등은 안됨 - 왜? 언제부터 언제까지를 표현할 수 없으므로)
		for (double aaa : array) { //foreach 클릭시 나옴 / (우측)반복대상 : array = 반복 대상의 처음부터 끝까지, 반복대상의 횟수를 알 필요 없이 사용 가능 
			// => 몇번 돌지에 대한 인지 단계가 없으므로 속도가 빠름
			System.out.println(aaa);
		}
		
	}
}
