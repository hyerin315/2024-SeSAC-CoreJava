package com.example.controller;

import java.sql.SQLException;

import com.example.model.PatientVO;
import com.example.model.PatientDAO;
import com.example.model.PatientDAOImpl;

public class InsertController { //Manager라고도 함 / Constructord
	private PatientDAO pDAO;
	
	public InsertController() { //Constructor
		pDAO = new PatientDAOImpl();
	}
	
	public boolean insert(PatientVO p) {
		boolean result = false;
		try {
			CalcController cc = new CalcController(p);
			result = pDAO.createPatient(p);	
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return result;
	}
}
