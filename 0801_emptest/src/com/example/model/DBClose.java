package com.example.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Author : Jinhee Lim, Hyerin Lim
 * When : Aug, 01, 2024
 * Objective : 데이터베이스를 종료하는 클래스입니다.
 * Environment : Windows 10 22H2(OS build 19045.4651), openjdk 17.0.11, IntelliJ 2024.1.4
 */

public class DBClose {
	public static void dbClose(Connection conn) {
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public static void dbClose(Connection conn, Statement stmt) {
		try {
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void dbClose(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
