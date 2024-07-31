//reduce()

import java.util.stream.IntStream;

public class StreamDemo2 {
	public static void main(String[] args) {
		IntStream is = IntStream.range(1, 101);  //Stream 생성
		int total = is.reduce(0, (a, b) -> a + b);
		System.out.println(total);
	}
}
