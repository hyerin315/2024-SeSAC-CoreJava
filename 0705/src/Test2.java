
public class Test2 {

	public static void main(String[] args) {
		// 이름 : 
		// 신장(cm) : 
		// 몸무게(kg) :
		// ~님은 BMI 지수 00.0이고 비만 전 단계 입니다.
		
		// 1) 이름 입력 받기
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		// 2) 신장 입력 받기
		System.out.print("신장 : ");
		double cm = sc.nextDouble();
		double m = cm * 0.01;
		
		// 3) 몸무게 입력 받기
		System.out.print("몸무게 : ");
		double kg = sc.nextDouble();
		
		// 4) BMI 지수 구하기
		// BMI 지수 공식 = 체중(kg)/키(cm)2제곱
		double bmi = kg/(m*m);
		
		
		// 5) BMI 지수에 따라 결과 출력하기
		// 지수에 따른 비만도
		// BMI < 18.5 = 저체중
		// 18.5 =< BMI =< 22.9 = 정상
		// 23 =< BMI =< 24.9 = 비만 전 단계
		// 25 =< BMI =< 29.9 = 1단계 비만
		// 30 =< BMI =< 34.9 = 2단계 비만
		// 35 =< BMI
		if (bmi < 18.5) {
			System.out.printf("%s님은 BMI 지수 %.1f이고 저체중입니다.", name, bmi); //%f : 지수로 출력, %.1f 소수점 이하 한자리까지만 출력
		} else if (bmi >= 18.5 && bmi < 23) {
			System.out.printf("%s님은 BMI 지수 %.1f이고 정상입니다.", name, bmi);
		} else if (bmi >= 23 && bmi < 25) {
			System.out.printf("%s님은 BMI 지수 %.1f이고 비만 전 단계입니다.", name, bmi);
		} else if (bmi >= 25 && bmi < 30) {
			System.out.printf("%s님은 BMI 지수 %.1f이고 1단계 비만입니다.", name, bmi); 
		} else if (bmi >= 30 && bmi < 35) {
			System.out.printf("%s님은 BMI 지수 %.1f이고 2단계 비만입니다.", name, bmi); 
		} else {
			System.out.printf("%s님은 BMI 지수 %.1f이고 3단계 비만입니다.", name, bmi); 
		}
		
		sc.close();

	}

}
