
public class ProductMgmt {
	public static void main(String[] args) {		
//		Product pencil = new Product();
//		
//		// 1. 연필
//		pencil.name = "모나미 연필";
//		pencil.price = 1000;
//		System.out.printf("name = %s, price = %,d%n원", //,(콤마) 찍으면 알아서 처리함 
//				pencil.name, pencil.price);
//		
//		// 2. 컴퓨터
//		Product computer = new Product();
//		computer.name = "컴퓨터";
//		computer.price = 20_000_00;
//		
//		System.out.printf("name = %s, price = %,d%n원",
//				computer.name, computer.price);
		
		Product[] array = new Product[2]; //공간 배열 2개
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		int i = 0; // 초기값
		while(i < 2) {
			array[i] = new Product(); //먼저, 상품을 만들어줘야 그 주소를 1번째 방에 넣을 수 있음
			
			System.out.print("Name :"); array[i].name = sc.next();
			System.out.print("Price :"); array[i].price = sc.nextInt();
			
			i++;
		}
		
		for(i = 0; i < 2; i++) { // while에서 2로 숫자가 늘어났기 때문에, i = 0으로 초기화 해줘야함
			System.out.printf("Name = %s, Price = %,d%n",
					array[i].name, array[i].price);
		}
		
	
	}
}
