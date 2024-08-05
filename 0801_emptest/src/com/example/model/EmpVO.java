package com.example.model;

/*
 * Author : Hyerin Lim
 * When : Aug, 01, 2024
 * Objective : 사원 정보를 담는 VO객체 입니다.
 * Environment : Windows 10 22H2(OS build 19045.4651), openjdk 17.0.11, IntelliJ 2024.1.4
 */

public class EmpVO {
	private String empno;       //사원번호
	private String ename;       //사원이름
	private String dname;       //부서명
	private int sal;			//기본급
	private int n_time;			//야간시간
	private int fam;			//가족수
	private int ho_sal;         //호급수당
	private int fam_sal;        //가족수당
	private int n_sal;          //야간수당
	private int total;          //총금액
	private int net_amount;		//실수령액
	
	
	//기본 생성자
	public EmpVO() { 
		
	}
	
	//empno만 넘기는 생성자
	public EmpVO(String empno) { 
		
	}

	//환자 정보
	public EmpVO(String empno, String ename, int sal, int n_time, int fam) {
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.n_time = n_time;
		this.fam = fam;
	}
	

	//Getter&Setter
	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getN_time() {
		return n_time;
	}

	public void setN_time(int n_time) {
		this.n_time = n_time;
	}

	public int getFam() {
		return fam;
	}

	public void setFam(int fam) {
		this.fam = fam;
	}

	public int getHo_sal() {
		return ho_sal;
	}

	public void setHo_sal(int ho_sal) {
		this.ho_sal = ho_sal;
	}

	public int getFam_sal() {
		return fam_sal;
	}

	public void setFam_sal(int fam_sal) {
		this.fam_sal = fam_sal;
	}

	public int getN_sal() {
		return n_sal;
	}

	public void setN_sal(int n_sal) {
		this.n_sal = n_sal;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getNet_amount() {
		return net_amount;
	}

	public void setNet_amount(int net_amount) {
		this.net_amount = net_amount;
	}

	
	@Override 
	public String toString(){
		return String.format("%-10s %-20s %-20s %10d %10d %10d %10d %10d %10d %10d %10d%n\";\r\n",
				empno, ename, sal, n_sal, fam, ho_sal, fam_sal, total, net_amount);
	}
	

}