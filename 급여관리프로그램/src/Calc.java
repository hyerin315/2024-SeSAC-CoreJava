
public class Calc {
	private Employee [] array;
	private int count;

	public Calc(Employee[] array, int count) {
		this.array = array;
		this.count = count;
	}
	void calc() {
		for(int i = 0 ; i < count ; i++) {
			Employee emp = this.array[i];
			int fee = this.calcFee(emp.getGrade(), emp.getHo());  //급여 구하기
			//지급액 = 급여 + 수당
			int money = fee + emp.getBonus();
			emp.setMoney(money);   //지급액 삽입
			double taxRate = this.getTaxRate(money); //세율 구하기
			int jojeng = this.getJojeng(money);   //조정액 구하기
			//세금 = (지급액 * 세율) - 조정액
			double tax = (money * taxRate) - jojeng;
			emp.setTax(tax);    //세금 삽입
			//차인지급액 = 지급액 - 세금
			long salary = (long)(money - tax);   //차인지급액 구하기
			emp.setSalary(salary);    //차인 지급액 삽입
		}
	}
	int calcFee(int grade, int ho) { //급, 호별 급여 구하기
		int fee = 0;
		switch(ho) {
			case 1:	 fee = (grade == 1) ? 95000 : 80000; break;
			case 2:  fee = (grade == 1) ? 92000 : 75000; break;
			case 3:  fee = (grade == 1) ? 89000 : 70000; break;
			case 4:  fee = (grade == 1) ? 86000 : 65000; break;
			case 5:  fee = (grade == 1) ? 83000 : 60000; break;
		}
		return fee;
	}
	double getTaxRate(int jigup) {  //지급액별 세율 구하기
		double tax = 0.0;
		if(jigup < 70000) tax = 0.0;
		else if(jigup >= 70000 && jigup < 80000) tax = 0.005;
		else if(jigup >= 80000 && jigup < 90000) tax = 0.007;
		else if(jigup >= 90000) tax = 0.012;
		return tax;
	}
	int getJojeng(int jigup) {  //지급액별 조정액 구하기
		int jojeng = 0;
		if(jigup < 70000) jojeng = 0;
		else if(jigup >= 70000 && jigup < 80000) jojeng = 300;
		else if(jigup >= 80000 && jigup < 90000) jojeng = 500;
		else if(jigup >= 90000) jojeng = 1000;
		return jojeng;
	}
}
