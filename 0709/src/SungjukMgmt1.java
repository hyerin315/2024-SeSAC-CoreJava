
public class SungjukMgmt1 {

	public static void main(String[] args) throws java.io.IOException {
		Student[] stdArray = new Student[3]; // 앞으로 학생들의 정보가 저장될 공간 확보
		
		// 파일 불러들이기
		java.util.Scanner sc = new java.util.Scanner(new java.io.File("sungjuk.dat")); //sungjuk.dat로 경로를 틀어서 file이 시작 - 끝은 입력 버퍼 => 읽는 것 (하드디스크가 갖다주면 자바그그럼 모음
//		System.out.println(sc.nextLine()); //첫번째 줄 읽기
//		System.out.println(sc.nextLine()); 
//		System.out.println(sc.nextLine()); 
		for(int i = 0; i < 3; i++) {
			stdArray[i] = new Student(); //비로소 여기서 학생의 주소 생성
			String line = sc.nextLine(); //2024-001 한지민 100 80 70 -> "2024-001" "   한지민   " : 잘릴 때 공백을 포함해서 자를 수도 있음 => 트리밍(빈 부분 잘라내야함)
			
			
			// 파싱 (각각을 맞는 그룹에 넣을 때)
			// split(String 정규식) -> 배열이 됨 String[]  (https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/regex/Pattern.html#sum)
			String[] array = line.split("\\s+"); // 화이트 스페이스(\s) 하나 이상(+)
			// 위의 \\s+는 역슬래시(역슬래시 + 문자 : escape 시퀀스로 이해)하면 제대로 이해함
			
			stdArray[i].hakbun = array[0].trim(); // 학번 => 트리밍함(쓸모없는 화이트 스페이스 없앰)
			stdArray[i].name = array[1].trim(); // 이름 => 트리밍함(쓸모없는 화이트 스페이스 없앰)
			stdArray[i].kor = Integer.parseInt(array[2].trim()); // 국어 String을 Integer로 변환 
			stdArray[i].eng = Integer.parseInt(array[3].trim()); // 영어
			stdArray[i].math = Integer.parseInt(array[4].trim()); // 수학
			
		}
		int j = 0; //초기값
		while(j < 3) {
			System.out.printf("%10s\t%10s\t%5d\t%5d\t%5d%n",
					stdArray[j].hakbun, stdArray[j].name,
					stdArray[j].kor, stdArray[j].eng,
					stdArray[j].math);
			j++;
		}
		
		
	}
}
