
public class Test1 {
	public static void main(String[] args) {		
		for (int i = 1; i <= 26; i++) { // i : 아래로 가는 애 
			for (int j = 1; j <= i; j++) { // j : 옆으로 가는애
				System.out.print((char)(j + 64));
			}
			System.out.println();
		}
	}
}
