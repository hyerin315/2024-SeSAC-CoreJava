package com.example.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

//view가 안보임, controller와 DB가 보임
public class PatientDAOImpl implements PatientDAO {
	private Connection conn;
	
	public PatientDAOImpl() {
		DBConnection dbConn = new DBConnection();
		this.conn = dbConn.getConnection(); //1~3단계
	}
	
	@Override
	// Override 조건
	// 1. 자식 메소드는 부모 메소드와 시그니쳐가 같아야한다
	// 2. 자식은 부모보다 같거나 더 넓어야한다
	// 3. 부모가 정의하지 않은 Exception은 자식이 정의할 수 없다 (Exception은 부모보다 자식이 적거나 같아야함)
	public boolean createPatient(PatientVO p) throws SQLException{
		Statement stmt = this.conn.createStatement(); //4단계
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO Patient  ");
		sb.append("VALUES (" + p.getNumber() + ",'" + p.getCode() + "',");
		sb.append(p.getDays() + "," + p.getAge() + ",'" + p.getDept() + "',");
		sb.append(p.getOperFee() + "," + p.getHospitalFee() + "," + p.getMoney() + ")");
		System.out.println(sb.toString());
		int su = stmt.executeUpdate(sb.toString()); //5단계
		
		DBClose.dbClose(this.conn, stmt);
		return (su==1)? true : false;
	}

	@Override
	public PatientVO readPatient(int number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientVO> readAllPatient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePatient(PatientVO p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePatient(int number) {
		// TODO Auto-generated method stub
		return false;
	}

}
