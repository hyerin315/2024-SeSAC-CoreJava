
public class ComditionDemo {

	public static void main(String[] args) {
		System.out.print("Favorite Seaeon(spring, summer, fall, winter : ");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		String season = sc.nextLine(); //입력한 값은 heap에 올라감, 8바이트
		
//		if (season == "spring") {//season은 참조할 주소를 갖고 있음. 그렇기에 값인 "spring"과 비교하면 같지 않을 수 밖에 없음
//			System.out.println("봄 : 개나리, 진달래");
//		} else if (season == "summer"){//summer는 heap에서 번지를 갖고 있음
//			System.out.println("여름 : 장미, 아카시아");
//		} else if (season == "fall") {
//			System.out.println("가을 : 백합, 코스모스");
//		} else {
//			System.out.println("겨울 : 동백, 매화");
//		} //이렇게만 하면 로직 에러(로직 에러는 알아내기 쉽지 않음) 뜸
		
		//if는 순서대로 끝까지 하나하나 다 넣어봐야함.
		//if는 switch로 바꿀 수 없음 
//		if (season.equals("spring")) {//equals()는 String class의 멤버 메소드이기 때문에, 주소가 필요함
//			System.out.println("봄 : 개나리, 진달래");
//		} else if (season.equals("summer")){//summer는 heap에서 번지를 갖고 있음
//			System.out.println("여름 : 장미, 아카시아");
//		} else if (season.compareTo("fall")==0) {//compareTo는 0이면 같고 아니면 같지 않음을 반환
//			System.out.println("가을 : 백합, 코스모스");
//		} else {
//			System.out.println("겨울 : 동백, 매화");
//		} //이렇게만 하면 로직 에러(로직 에러는 알아내기 쉽지 않음) 뜸
		
		
		//compareTO 비교
		//ASKII에서 대문자 A를 비교한다 했을 때 65-65는 정확히 같을 시 0으로 같다는 뜻
		//static이 아님 -> 번지를 갖고 있음
		
		
		//if는 위에서부터 순차적으로 비교함 -> 그래서 느림
		//switch는 다이렉트로 감
		
		
		switch(season) {//String을 넣는 건 java 1.6까지만,
		//switch는 맞는 것만 출력하고 빠져나옴
		//switch는 if로 바꿀 수 있음
		//1. switch는 들어가는 변수의 타입을 생각해야하고
		//2. break를 생각해야함
			case "sparing" : System.out.println("봄 : 개나리, 진달래");
			break;
			case "summer" : System.out.println("여름 : 장미, 아카시아");
			break;
			case "fall" : System.out.println("가을 : 백합, 코스모스");
			break;
			default : System.out.println("겨울 : 동백, 매화");
		}
		
		
	}

}