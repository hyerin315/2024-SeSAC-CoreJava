package com.example.controller;

import java.sql.SQLException;
import com.example.model.EmpDAO;
import com.example.model.EmpDAOImpl;
import com.example.model.EmpVO;

/*
 * Author : Jinhee Lim
 * When : Aug, 01, 2024
 * Objective : 입력받은 직원의 정보를 db에 저장하기 위한 함수를 호출합니다.
 * Environment : Windows 10 22H2(OS build 19045.4651), openjdk 17.0.11, IntelliJ 2024.1.4
 */

public class InsertController {
	private EmpDAO eDAO;
	
	public InsertController() { //Constructor
		eDAO = new EmpDAOImpl();
	}
	
	public boolean insert(EmpVO e) {
		boolean result = false;
		try {
			CalcController cc = new CalcController(e);
			result = eDAO.createEmp(e);	
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return result;
	}
}
