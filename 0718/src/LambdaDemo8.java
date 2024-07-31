import java.util.Arrays;
import java.util.List;

public class LambdaDemo8 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("사과", "배", "딸기", "복숭아", "레몬", "망고", "수박");
		//list에 저장된 각 element를 iterate해서 출력하기
		//1st way
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ", ");
		}
		System.out.println();
		//2nd way
		for (String str : list) System.out.print(str + ", ");
		System.out.println();
		//3rd way
		list.forEach(str -> System.out.print(str + ", "));
	}
}
