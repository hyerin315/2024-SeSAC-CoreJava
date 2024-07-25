package com.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Output extends Object{
	private Connection conn;
	private List<StudentVO> list;   //field
	
	public Output(List<StudentVO> list) {
		this.list = list;
		DBConnection dbconn = new DBConnection();
		this.conn = dbconn.getConnection();  //1. 2. 3
	}
	
	void output() {
		Statement stmt = null; 
		for(StudentVO std : this.list) {
			//System.out.println(sql);
			try {
				stmt = this.conn.createStatement();//4
				String sql = "INSERT INTO Sudent  ";
				sql += "VALUES ('" + std.getHakbun() + "', '" + std.getName() + "', ";
				sql += std.getKor() + ", " + std.getEng() + ", " + std.getMat();
				sql += ", " + std.getEdp() + ", " + std.getTot() + ", " + std.getAvg();
				sql += ", '" + std.getGrade() + "')";
				stmt.executeUpdate(sql);   //5.
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}   
		};
		DBClose.dbClose(this.conn, stmt);   //6. 생략, 7.
		System.out.println("DB Inserted Successfully");
	}
}