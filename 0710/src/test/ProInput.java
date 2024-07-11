package test;

public class ProInput {
	public static void main(String[] args) throws java.io.IOException {
		Product[] proArray = new Product[7]; // 프로덕트 배열 생성
		
		// 파일 불러들이기
		java.util.Scanner sc = new java.util.Scanner(new java.io.File("productdata.txt"));
		
		
		for (int i = 0; i < proArray.length; i++) {
			proArray[i] = new Product();
			String line = sc.nextLine(); //트리밍 : 불러오는 데이터 공백 지우기
			
			//파싱
			String[] array = line.split("\\s+");
			
			//매칭
			proArray[i].setName(array[0]);
			proArray[i].setCount(Integer.parseInt(array[1]));
			proArray[i].setSell(Integer.parseInt(array[2]));
			proArray[i].setBuy(Integer.parseInt(array[3]));
			proArray[i].setDelivery(Integer.parseInt(array[3]));	
		}
		int j = 0;
		while(j < 7 ) {
			System.out.printf("%10s\t%5d\t%5d\t%5d\t%5d\t%n",
					proArray[j].getName(), proArray[j].getCount(), proArray[j].getSell(),
					proArray[j].getBuy(), proArray[j].getDelivery());
			j++;
		}
		
	}
}
