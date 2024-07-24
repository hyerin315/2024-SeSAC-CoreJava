package com.example;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class JDBCDemo1 {
	private DBConnection dbconn;
	private Connection conn;
	public JDBCDemo1() {
		this.dbconn = new DBConnection();
		this.conn = this.dbconn.getConnection();
	}
	
	public static void main(String[] args) {
		JDBCDemo1 demo = new JDBCDemo1(); // 1~3단계
		Scanner scan = new Scanner(System.in);
		System.out.println("What's name? : ");
		String name = scan.next().toUpperCase();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = demo.conn.createStatement(); // 4단계
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT ename, sal, grade ");
			sb.append("FROM emp, salgrade  ");
			sb.append("WHERE (sal BETWEEN losal AND hisal) AND ename = '"+ name +"'");
			rs = stmt.executeQuery(sb.toString()); // 5단계
			while(rs.next()) { // 6단계
				System.out.printf("%s\t%.1f\t%d%n", 
						rs.getString("ename"), rs.getDouble("sal"), rs.getInt("grade"));
			}
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
		} finally { //7단계
			DBClose.dbClose(demo.conn, null, null);
		}
	
	}

}
