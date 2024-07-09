
public class SungjukMgmt {

	public static void main(String[] args) {
		int [][] jumsus = {
				{67, 89, 100},
				{77, 99, 56},
				{100, 99, 88}
		};
		for(int i = 0; i < jumsus.length; i++) {//전체 학생 루프
			int tot = 0;
			for(int j = 0; j < jumsus[i].length; j++) tot += jumsus[i][j]; //옆으로 가며 성적 누적, 할 일이 한 개면 중괄호 없어도 됨
			double avg = tot / 3;
			char grade = (avg >= 90) ? 'A' :
							(avg >= 80) ? 'B' :
								(avg >= 70) ? 'C' :
									(avg >= 60) ? 'D': 'F';
			for(int j = 0 ; j < jumsus[i].length; j++) {
				System.out.printf("%5d\t", jumsus[i][j]);
				System.out.printf("%5d\t%10.1f\t%5c%n", tot, avg, grade);
			}
		}
	}
}
