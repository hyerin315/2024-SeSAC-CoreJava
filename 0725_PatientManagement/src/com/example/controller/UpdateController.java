package com.example.controller;

import java.sql.SQLException;

import com.example.model.PatientDAO;
import com.example.model.PatientDAOImpl;
import com.example.model.PatientVO;

public class UpdateController {
	private PatientDAO pDao;

	public UpdateController() {
		this.pDao = new PatientDAOImpl();
	}
	
	public boolean update(PatientVO p) {
		boolean flag = false;
		try {
			CalcController cc = new CalcController(p); // 계산 다시 (바뀌었으니까)
			this.pDao.updatePatient(p);
			flag = true;
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
			flag = false;
		}
		return flag;
	}

}
