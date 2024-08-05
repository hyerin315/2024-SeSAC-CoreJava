package com.example.view;

import java.util.List;
import java.util.Scanner;

import javax.security.auth.kerberos.DelegationPermission;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultTextUI;

import com.example.controller.DeleteController;
import com.example.controller.InsertController;
import com.example.controller.SelectController;
import com.example.controller.UpdateController;
import com.example.model.PatientVO;


//view는 controller밖에 모름
public class PatientView {
	private Scanner scan;
	
	public PatientView() {
		this.scan = new Scanner(System.in);
		boolean isContinue = true;
		while(isContinue) {
			switch(showMenu()) {
				// 1. 환자 등록하기
				case 1: 
					insertMenu(); 
					break;
					
				// 2. 환자 검색하기
				case 2:
					selectMenu();
					break;
				
				// 3. 환자 목록 가져오기
				case 3:
					selectAllMenu();
					break;
					
				// 4. 환자 수정하기
				case 4:
					updateMenu();
					break;
				
				// 5. 환자 삭제하기
				case 5:
					deleteMenu();
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
		System.out.println("│     새싹 정형외과 환자 관리 프로그램    │");
		System.out.println("└ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ┘");
	
			System.out.println("┌ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ┐");
			System.out.println("│ 1. 환자 등록                      │");
			System.out.println("│ 2. 환자 검색                      │");
			System.out.println("│ 3. 환자 목록                      │");
			System.out.println("│ 4. 환자 수정                      │");
			System.out.println("│ 5. 환자 삭제                      │");
			System.out.println("│ 99. 프로그램 종료                  │");
			System.out.println("└ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ┘");
			System.out.println("원하시는 메뉴 번호를 선택해주세요 >>  ");
			return scan.nextInt();
	}

	
	
	
	// 1. 환자 등록하기
	private void insertMenu() {
		String i_o = null;
		do {
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
			InsertController ic = new InsertController();
			
			if (ic.insert(p)) {
	            System.out.println("환자 등록 성공");
	        } else {
	            System.out.println("환자 등록 실패");
	            break;
	        }
			System.out.print("입력 / 출력(I/O) ? :");
			
			i_o = this.scan.next();
			
		}while(i_o.toUpperCase().equals("I"));
		
	}
	
	
	
	// 2. 환자 검색하기
	private void selectMenu() {
		SelectController sc = new SelectController();
		System.out.print("검색하실 환자번호 : ");
		int number = this.scan.nextInt();
		PatientVO p = sc.selectPatient(number);
		if(p == null) { // 환자가 없다면
			System.out.println("검색하신 환자를 찾을 수 없습니다.");
		} else { // 환자가 있다면
			System.out.printf("%d\t%s\t%,d\t%,d\t%,d%n", 
					p.getNumber(), p.getDept(), p.getOperFee(),
					p.getHospitalFee(), p.getMoney());
		}
	}
	
	

	// 3. 모든 환자 가져오기
	private void selectAllMenu() {
		SelectController sc = new SelectController();
		List<PatientVO> list = sc.selectAllPatient();
		System.out.println("번호\t진찰부서\t진찰비\t입원비\t진료비");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		if(list == null || list.size() == 0) System.out.println("등록된 환자가 없습니다.");
		else if(list.size() > 0) {
			list.forEach(p -> System.out.printf("%d\t%s\t%,d\t%,d\t%,d%n", 
					p.getNumber(), p.getDept(), p.getOperFee(),
					p.getHospitalFee(), p.getMoney()));
		}
	}

	
	
	// 4. 환자 수정하기
	private void updateMenu() {
		SelectController sc = new SelectController();
		System.out.print("검색하실 환자 번호 : ");
		int number = this.scan.nextInt();
		PatientVO p = sc.selectPatient(number);
		if(p == null) { // 환자가 없다면
			System.out.println("검색하신 환자를 찾을 수 없습니다.");
		} else { // 환자가 있다면			
			
			//loop1 :
			while (true) {
				System.out.println("*) 환자 등록번호 : " + p.getNumber());
				System.out.println("1) 환자 진료코드 : " + p.getCode());
				System.out.println("2) 환자 입원일수 : " + p.getDays());
				System.out.println("3) 환자 나이 : " + p.getAge());
				System.out.println("수정하실 항목의 번호를 입력하시오 : ");
				int choice = this.scan.nextInt();
				
				switch(choice) { // 선택에 따라 결과가 달라지므로 switch
					case 1:
						System.out.print("수정할 진료코드 : ");
						String code = this.scan.next();
						p.setCode(code);
						//continueLoop = false;
						break;
						
					case 2:
						System.out.print("수정할 입원일수 : ");
						int days = this.scan.nextInt();
						p.setDays(days);
						//continueLoop = false;
						break;
						
					case 3:	
						System.out.print("수정할 환자나이 : ");
						int age = this.scan.nextInt();
						p.setAge(age);
						//continueLoop = false;
						break;
						
					default:
						System.out.println("없는 번호입니다. 다시 입력하세요.");
						//continue loop1;
						continue;
				}
				break; // 유효한 입력을 받으면 루프 종료
			}
			UpdateController uc  = new UpdateController();
			p.setNumber(number);
			boolean flag = uc.update(p);
			
			if(flag) System.out.println("환자 정보 수정 성공");
			else System.out.println("환자 정보 수정 실패");
		}		
	}

	
	// 5. 환자 삭제하기
	private void deleteMenu() {
		SelectController sc = new SelectController();
		List<PatientVO> list = sc.selectAllPatient();
		System.out.println("번호\t진찰부서\t진찰비\t입원비\t진료비");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		list.forEach(p -> System.out.printf("%d\t%s\t%,d\t%,d\t%,d%n", 
				p.getNumber(), p.getDept(), p.getOperFee(),
				p.getHospitalFee(), p.getMoney()));
		System.out.print("삭제할 환자 등록 번호 :");
		int number = this.scan.nextInt();
		DeleteController dc = new DeleteController();
		if(dc.delete(number)) JOptionPane.showMessageDialog(null,
				number + "번 환자의 정보가 삭제됐습니다.");
		else System.out.println("삭제 실패");
	}
	
}
