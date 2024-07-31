package com.example.controller;

import java.sql.SQLException;
import java.util.List;

import com.example.model.PatientDAO;
import com.example.model.PatientDAOImpl;
import com.example.model.PatientVO;

public class SelectController { // select & select All
	private PatientDAO pDAO;

	public SelectController() {
		this.pDAO = new PatientDAOImpl();
	}

	public List<PatientVO> selectAllPatient() {
		List<PatientVO> list = null;

		try {
			list = this.pDAO.readAllPatient();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}

	public PatientVO selectPatient(int number) {
		PatientVO p = null;
		try {
			p = this.pDAO.readPatient(number);
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return p;
	}
}
