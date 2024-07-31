package com.example.controller;

import java.sql.SQLException;

import com.example.model.PatientDAOImpl;
import com.example.model.PatientDAO;

public class DeleteController {// controller의 역할 : DAO를 부르는 역할
	private PatientDAO dao;
	
	public DeleteController() {
		this.dao = new PatientDAOImpl();
	}
	
	public boolean delete(int number) {
		boolean inSuccess = false;
		
		try {
			inSuccess = this.dao.deletePatient(number);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return inSuccess;
	}
	
}
