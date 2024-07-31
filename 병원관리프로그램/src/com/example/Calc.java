package com.example;

import java.util.List;

public class Calc {
	private List<Patient> list;
	
	public Calc(List<Patient> list) {
		this.list = list;
	}

	public void calc() {
		for(Patient p : this.list) {
			int oneday = (p.getDays() <= 3) ? 30000 : 25000;   //1일 입원비
			int totalHospitalFee = oneday * p.getDays();   //총입원비
			int hospitalFee = (int)(totalHospitalFee * this.getRate(p.getDays()));  //입원비
			int operFee = this.getOperFee(p.getAge());    //진찰비
			int money = operFee + hospitalFee;  //진료비
			String dept = this.getDept(p.getCode());   //진찰부서
			p.setDept(dept);
			p.setHospitalFee(hospitalFee);
			p.setMoney(money);
			p.setOperFee(operFee);
		}
	}
	
	private String getDept(String code) {
		String dept = null;
		switch(code) {
			case "MI":  dept = "외과"; break;
			case "NI":  dept = "내과"; break;  
			case "SI":  dept = "피부과"; break;
			case "TI":  dept = "소아과"; break;
			case "VI":  dept = "산부인과"; break;
			case "WI":  dept = "비뇨기과"; break;
		}
		return dept;
	}
	
	private int getOperFee(int age) {
		int operFee = 0;
		switch(age / 10) {
			case 0 : operFee = 7000;  break;
			case 1 : operFee = 5000;  break; 
			case 2 :  operFee =8000;  break;
			case 3 :  operFee = 7000;  break;
			case 4 :  operFee =4500;  break;
			default :  operFee = 2300;  
		}
		return operFee;
	}
	
	private double getRate(int days) {
		double rate = (days < 10) ? 1.00 : 
								(days < 15) ? 0.85 :
									(days < 20) ? 0.80 :
										(days < 30) ? 0.77 :
											(days < 100) ? 0.72 : 0.68;
		return rate;
	}
}
