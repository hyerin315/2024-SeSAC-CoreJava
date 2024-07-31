package com.example.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

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
	public PatientVO readPatient(int number) throws SQLException {
		String sql = "{ call sp_select_one_patient(?) }"; // 불완전한 SQL 문장
		CallableStatement cstmt = this.conn.prepareCall(sql); //4단계
		cstmt.setInt(1, number); // 완전한 SQL 문장
		ResultSet rs = cstmt.executeQuery(); //5단계
		boolean flag = rs.next(); // 못찾으면 false, 찾으면 true
		PatientVO p = null;
		if(flag) { // 찾았을때
			p = new PatientVO(rs.getInt("number"), rs.getString("code"), rs.getInt("days"), rs.getInt("age"));
			p.setDept(rs.getString("dept"));
			p.setOperFee(rs.getInt("operfee"));
			p.setHospitalFee(rs.getInt("hospitalfee"));
			p.setMoney(rs.getInt("money"));
		} else { // 못찾았을떄
		
		}
		return p;
	}

	@Override
	public List<PatientVO> readAllPatient() throws SQLException{
//		String sql = "SELECT number, dept, operfee, hospitalfee, money ";
//		sql += "FROM Patient ORDER BY number DESC";
		
		String sql = "{ call sp_select_all_patient() }";
		
		CallableStatement stmt = this.conn.prepareCall(sql); //4단계
		ResultSet rs = stmt.executeQuery(); //5단계
		boolean flag = rs.next();
		List<PatientVO> list = new ArrayList<PatientVO>(); //capacity 10개 생성
		if(!flag) { 
			//  한번도 add()를 하지 않아서 결국 list.size() == 0
		} else { 
				do {// 6단계
					int number = rs.getInt("number");
					String dept = rs.getString("dept");
					int operfee = rs.getInt("operfee");
					int hospitalfee = rs.getInt("hospitalfee");
					int money = rs.getInt("money");
					
					PatientVO p = new PatientVO();
					p.setNumber(number);
					p.setDept(dept);
					p.setOperFee(operfee);
					p.setHospitalFee(hospitalfee);
					p.setMoney(money);
					list.add(p);
				}while (rs.next());
		}
		DBClose.dbClose(conn, stmt, rs); //7단계
		return list;
	}

	@Override
	public boolean updatePatient(PatientVO p) throws SQLException { // 계산이 끝난 환자 p
		String sql = " { call sp_update_patient(?, ?, ?, ?, ?, ?, ?, ?) }";
		CallableStatement cstmt = this.conn.prepareCall(sql);
		
		//완전한 SQL 문장
		cstmt.setInt(1, p.getNumber());
		cstmt.setString(2, p.getCode());
		cstmt.setInt(3, p.getDays());
		cstmt.setInt(4, p.getAge());
		cstmt.setString(5, p.getDept());
		cstmt.setInt(6, p.getOperFee());
		cstmt.setInt(7, p.getHospitalFee());
		cstmt.setInt(8, p.getMoney());
		
		cstmt.execute(); // 5단계
		DBClose.dbClose(conn, cstmt); // 7단계
		return true;
	}

	@Override
	public boolean deletePatient(int number) throws SQLException {
		//Statement stmt = this.conn.createStatement(); 
		// Statement : class 아님, Interface임 (Interface는 new를 못씀)
		String sql = "DELETE FROM Patient WHERE number = ?"; //불완전한 SQL문
		PreparedStatement pstmt = this.conn.prepareStatement(sql); // 4단계
		// -> Statement의  자식 PreparedStatement : ? WHERE ID = ? (불완전한 스테이트먼트로 값을 안써도 됨, "'" 안써도 됨) 
		pstmt.setInt(1, number); // 완전한 SQL 문장
		int row = pstmt.executeUpdate(); // 5단계 SQL 문을 실행하고 영향을 받은 행의 수를 반환
		DBClose.dbClose(conn, pstmt);    // 7단계 데이터베이스 연결과 PreparedStatement 객체를 닫음
		return (row == 1) ? true : false; // 삭제된 행의 수가 1이면 true 반환, 그렇지 않으면 false 반환
		}

}
