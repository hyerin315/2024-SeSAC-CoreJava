import java.io.FileNotFoundException;

public class Input {
	
	// 생성자는 아래 두개를 초기화함
	private java.util.Scanner sc; // member
	public Student[] array; // filed
	

	// 초기화 
	// 생성자는 앞에 리턴타입이 없어야함
	Input (Student[] array) throws FileNotFoundException { // 앞에 아무것도 안쓰면 Default : 같은 성적 프로그램 패키지 안에서 접근 가능
		this.sc = new java.util.Scanner(new java.io.File("sungjuk.txt"));
		this.array = array; 
	}// 에러 메세지 던지면 input 메소드를 호출한 곳으로 날아감
	
	void input() {
		for(int i = 0; i < this.array.length; i++) { // length = 12
			String line = this.sc.nextLine(); //1101     한송이     78     87     83    78
			
			// 문자열 파싱 => String [] 배열로 만들어주는 -> String 클래스의 split(정규식)
			// Scanner가 파싱도 지원함 (앞뒤 글자수에 상관없이 앞뒤의 빈공간을 자를거야)
			java.util.Scanner s = new java.util.Scanner(line).useDelimiter("\\s+");
			
			String hakbun = s.next(); //1101
			String name = s.next(); // 한송이
			int kor = s.nextInt(); // 78
			int eng = s.nextInt(); // 87
			int mat = s.nextInt(); // 83
			int edp = s.nextInt(); // 78
			
			this.array[i] = new Student(hakbun, name, kor, eng, mat, edp); // 이때 학생이 만들어짐
		}
		
	}

}
