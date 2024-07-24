package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		DBConnection dbconn = new DBConnection();
		Connection conn = dbconn.getConnection(); // 1단계~3단계까지 처리
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement(); // 4단계
			StringBuffer sb = new StringBuffer(); // String을 더하기로 계속 이으면 속도가 느림, StringBuffer를 사용하여 append로 붙이는 게 빠름
			sb.append("SELECT empno, ename, sal, d.deptno, dname, loc ");
			sb.append("FROM emp e JOIN dept d ON(e.deptno = d.deptno) ");
			sb.append("WHERE ename = 'SMITH' ");
			rs = stmt.executeQuery(sb.toString()); // 5단계
			
			while(rs.next()) { // 6단계
				System.out.printf("%d\t%s\t%.1f\t%d\t%s\t%s%n", 
						rs.getInt("empno"), rs.getString("ename"), rs.getDouble("sal"),
						rs.getInt("d.deptno"), rs.getString("dname"), rs.getString("loc"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DBClose.dbClose(conn, stmt, rs); // 7단계
		}

	}

}
