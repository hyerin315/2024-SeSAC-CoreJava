package com.example.controller;

import com.example.*;
import com.example.model.EmpVO;

/*
 * Author : Jinhee Lim
 * When : Aug, 01, 2024
 * Objective : 입력받은 환자의 정보를 계산합니다.
 * Environment : Windows 10 22H2(OS build 19045.4651), openjdk 17.0.11, IntelliJ 2024.1.4
 */

public class CalcController {
    private EmpVO e;

    public CalcController(EmpVO e) {
        this.e = e;
        this.calc();
    }

    public void calc() {
        int fam_sal = e.getFam() * 7000; // 가족수당
        int ho_sal = getHo_sal(e.getEmpno()); // 호급수당
        int baseSalary = getSal(e.getSal()); // 기본급
        int n_sal = getN_sal(e.getN_time()); // 야간수당
        int total = ho_sal + baseSalary + n_sal + fam_sal; // 총금액
        double tax = ho_sal * 0.1; // 세금
        int netAmount = (int) (total - tax);

        String dept = getDept(e.getEmpno()); // 부서명

        e.setHo_sal(ho_sal);
        e.setFam_sal(fam_sal);
        e.setN_sal(n_sal);
        e.setTotal(total);
        e.setDname(dept);
        e.setNet_amount(netAmount);
        
    }

    // 입력된 사원번호의 첫번째 글자에 따라 부서를 분류합니다.
    private String getDept(String empno) {
        String dept = null;
        switch (empno.substring(0, 1).toUpperCase()) {
            case "A":
                dept = "영업부";
                break;
            case "B":
                dept = "업무부";
                break;
            case "C":
                dept = "홍보부";
                break;
            case "D":
                dept = "인사부";
                break;
            case "E":
                dept = "경리부";
                break;
            case "F":
                dept = "판촉부";
                break;
            case "G":
                dept = "총무부";
                break;
        }
        return dept;
    }

    // 사원번호의 두 번째 자리 값을 추출해 호급수당을 계산합니다.
    private int getHo_sal(String empno) {
        int ho_sal = 0;
        switch (Integer.parseInt(empno.substring(1, 2))) {
            case 1:
                ho_sal = 900000;
                break;
            case 2:
                ho_sal = 400000;
                break;
            case 3:
                ho_sal = 600000;
                break;
            case 4:
            case 6:
            case 7:
                ho_sal = 800000;
                break;
            case 5:
                ho_sal = 300000;
                break;
        }
        return ho_sal;
    }

    // 기본급을 계산합니다.
    private int getSal(int sal) {
        int salAmount = 0;
        switch (sal) {
            case 1:
                salAmount = 15000;
                break;
            case 2:
                salAmount = 25000;
                break;
            case 3:
                salAmount = 35000;
                break;
            case 4:
                salAmount = 45000;
                break;
        }
        return salAmount;
    }

    // 야간수당을 계산합니다.
    private int getN_sal(int n_time) {
        int n_sal = 0;
        switch (n_time) {
            case 1:
                n_sal = 1500;
                break;
            case 2:
                n_sal = 2500;
                break;
            case 3:
                n_sal = 3500;
                break;
            case 4:
                n_sal = 4500;
                break;
        }
        return n_sal;
    }
}