
public class VariableDemo {
	//VariableDemo는 멤버가 eng 밖에 없음, 다른애들은 다 밖에 있음 -> main과 VariableDemo는 따로 놂 왜? static이 있으니까
	//math는 VariableDemo소속이나 static이 있어 main에서 사용 가능함
	
	int eng = 100; //instance variable 인스턴스 변수 - static이 없고 main 안에 있지 않은 것 / 클래스 멤버로 존재 (3) 아직 올라오지 않음
	static int math = 80; //class variable 클래스 변수 - static이 있고 main 안에 있지 않은 것/클래스 안에만 존재 가능 -> 제일 먼저 메모리에 올라옴 (static 덕분에) 순서 (1)

	
	public static void main(String[] args) {
		//*변수 종류가 3가지인 이유는 위치가 다르고 사용하는 목적이 다르기 때문
		//int kor; //선언만 하면 에러남 -> 초기화 되지 않았기 때문에 (지역변수는 반드시 초기화 해야 사용할 수 있음)
		int kor = 90; //local variable  지역변수 - 중괄호 안에 있음 (2) main이 실행되면 자동으로 올라옴
		
		
		System.out.printf("수학점수 = %d\n", Demo.math); //static으로 선언된 math가 두개일때는 앞에 소속을 명확히 한다
		System.out.printf("수학점수 = %d\n", kor);
		//System.out.printf("수학점수 = %d\n", eng); //에러메세지 : static이 아니어서 못써! -> main에서는 그럼 static 변수나 지역변수밖에 못쓴다는 의미
		VariableDemo vd = new VariableDemo(); // VariableDemo로 vd의 타입을 만들어줘야 vd에 VariableDemo의 번지가 저장됨 -> vd는 위치를 알고 있음
		
		//변수 선언 방식의 따라 위치가 다름
		// math는 stack과 heap 밖에 있고
		//eng는 heap에  있는 VariableDemo 안의 eng에 있음 (vd는 stack에서 eng을 참조함)
		// kor는 stack에 있음
		
		System.out.printf("영어 점수 = %d\n", vd.eng); //vd의 주소를 따라 eng을 찾아가자
		
		
		Demo d = new Demo(); //집을 짓고 d(주소)를 통해 Demo의 eng에 접근
		System.out.printf("영어 점수 = %d\n", d.eng); //eng은 각 집 속에 있다. 정확하게 배달하려면 주소로 찾아감
	
	}

}


class Demo{//프로젝트 안에는 클래스가 원래 하나여야 하지만, 하나 더 만들어서 예제로 씀
	static int math = 70; //class variable
	int eng = 50; //instance variable 	
}

