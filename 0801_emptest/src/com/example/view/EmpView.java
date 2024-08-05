package com.example.view;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import javax.security.auth.kerberos.DelegationPermission;
import javax.swing.JOptionPane;
import com.example.controller.InsertController;
import com.example.controller.SelectController;
import com.example.model.EmpVO;


/*
 * Author : Jinhee Lim(insertMenu()), Hyerin Lim(EmpView(), showMenu(), selectAllMenu())
 * When : Aug, 01, 2024
 * Objective : 사원 데이타를 입력 받고 출력합니다.
 * Environment : Windows 10 22H2(OS build 19045.4651), openjdk 17.0.11, IntelliJ 2024.1.4
 */



public class EmpView {
	private Scanner scan;
	
	public EmpView() {
		this.scan = new Scanner(System.in);
		boolean isContinue = true;
		while(isContinue) {
			switch(showMenu()) {

				// 1. 데이터 입력하기
				case 1:
				try {
					insertMenu();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				// 2. 데이터 출력하기
				case 2:
					selectAllMenu();
					break;
					
				// 99. 종료하기
				case 99: 
					isContinue = false; 
					break;
				default: System.out.println("잘못된 번호를 입력하셨습니다.");
				JOptionPane.showMessageDialog(null, "Program is over...");
			}
		}
		JOptionPane.showMessageDialog(null, "Program is over...");
	}



	//  메뉴
	private int showMenu() {
		System.out.println("┌ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ┐");
		System.out.println("│         사원관리 프로그램           │");
		System.out.println("└ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ┘");
	
			System.out.println("┌ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ┐");
			System.out.println("│ 1. 데이타 입력                     │");
			System.out.println("│ 2. 데이타 출력                     │");
			System.out.println("│ 99. 프로그램 종료                  │");
			System.out.println("└ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ┘");
			System.out.println("원하시는 메뉴 번호를 선택해주세요 >>  ");
			return scan.nextInt();
	}

	
	

	
	// 1. 데이터 입력하기
    private void insertMenu() throws IOException {
        int sal = 0;
        int n_time = 0;
        int fam = 0;
        String i_o = null;
        do {
            System.out.println("데이터 입력 메뉴");
            System.out.println("사원 번호 :");
            String empno = this.scan.next();

            System.out.println("사원 이름 : ");
            String ename = this.scan.next();

            do {
                System.out.println("기본급 ( 1 ~ 4 ) : ");
                sal = this.scan.nextInt();
                if (sal > 4 || sal < 1) {
                    System.out.println("잘못 입력 하셨습니다. 다시 입력해주세요.");
                }
            } while (sal > 4 || sal < 1);

            do {
                System.out.println("야간시간 ( 1 ~ 4 ) : ");
                n_time = this.scan.nextInt();
                if (n_time > 4 || n_time < 1) {
                    System.out.println("잘못 입력 하셨습니다. 다시 입력해주세요.");
                }
            } while (n_time > 4 || n_time < 1);

            do {
                System.out.println("가족 수 ( 1 ~ 5 ) : ");
                fam = this.scan.nextInt();
                if (fam > 5 || fam < 1) {
                    System.out.println("잘못 입력 하셨습니다. 다시 입력해주세요.");
                }
            } while (fam > 5 || fam < 1);

            EmpVO emp = new EmpVO(empno, ename, sal, n_time, fam);
            InsertController ic = new InsertController();

            if (ic.insert(emp)) {
                System.out.println("데이타 등록 성공");
            } else {
                System.out.println("데이타 등록 실패");
                break;
            }
            System.out.print("입력 / 출력(I/O) ? :");

            i_o = this.scan.next();

        } while (i_o.toUpperCase().equals("I"));
    }
	
	


	// 2. 데이터 출력하기
	private void selectAllMenu() {
		SelectController sc = new SelectController();
		List<EmpVO> list = sc.selectAllEmp();
		System.out.println("사원번호\t사원이름\t부서명\t기본급\t호급수당\t가족수당\t야간수당\t총금액\t실수령액");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		if(list == null || list.size() == 0) System.out.println("등록된 데이타가 없습니다.");
		else if(list.size() > 0) {
			list.forEach(emp -> System.out.printf("%s\t%s\t%s\t%d\t%d\t%d\t%d\t%d\t%d%n", 
					emp.getEmpno(), emp.getEname(), emp.getDname(), emp.getSal(), emp.getHo_sal(), emp.getFam_sal(), 
					emp.getN_sal(), emp.getTotal(), emp.getNet_amount()));
		}
	}
	
}
