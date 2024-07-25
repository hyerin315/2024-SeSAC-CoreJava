package com.example.view;

import java.util.Scanner;
import com.example.controller.InsertController;
import com.example.model.PatientVO;


//view는 controller밖에 모름
public class PatientView {
	private InsertController ic;
	private Scanner scan;
	
	public PatientView() {
		this.ic = new InsertController();
		this.scan = new Scanner(System.in);
		boolean isContinue = true;
		while(isContinue) {
			switch(showMenu()) {
				case 1: insertMenu(); break;
				case 2:
				case 3:
				case 4:
				case 5:
				case 99: isContinue = false; break;
				default: System.out.println("잘못된 번호를 입력하셨습니다.");
			}
		}
	}
	private void insertMenu() {
		System.out.println("환자 등록 메뉴");

		System.out.println("환자 등록 번호 : ");
		int number = this.scan.nextInt();
		
		System.out.println("진료 코드 : ");
		String code = this.scan.next();
		
		System.out.println("입원 일수 : ");
		int days = this.scan.nextInt();
		
		System.out.println("환자 나이 : ");
		int age = this.scan.nextInt();
		
		PatientVO p = new PatientVO(number, code, days, age);
		if (this.ic.insert(p)) {
            System.out.println("환자 등록 성공");
        } else {
            System.out.println("환자 등록 실패");
        }
		
	}
	
	private int showMenu() {
		System.out.println("┌-----------------------------------┐");
		System.out.println("│     새싹 정형외과 환자 관리 프로그램     │");
		System.out.println("└-----------------------------------┘");
	
			System.out.println("┌-----------------------------------┐");
			System.out.println("│1. 환자 등록                         │");
			System.out.println("│2. 환자 검색                         │");
			System.out.println("│3. 환자 목록                         │");
			System.out.println("│4. 환자 수정                         │");
			System.out.println("│5. 환자 삭제                         │");
			System.out.println("│99. 프로그램 종료                     │");
			System.out.println("└-----------------------------------┘");
			System.out.println("원하시는 메뉴 번호를 선택해주세요 >>  ");
			return scan.nextInt();
	}

}
