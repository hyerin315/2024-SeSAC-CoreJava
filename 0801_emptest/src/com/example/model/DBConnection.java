package com.example.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * Author : Jinhee Lim, Hyerin Lim
 * When : Aug, 01, 2024
 * Objective : 데이터베이스와 연결을 관리하는 클래스입니다.
 * Environment : Windows 10 22H2(OS build 19045.4651), openjdk 17.0.11, IntelliJ 2024.1.4
 */

public class DBConnection {
	private Properties info;
	
	// 생성자
	public DBConnection() {
		this.info = new Properties();
		File file = new File("dbinfo.properties");
		try {
			this.info.load(new FileInputStream(file));
		} catch (IOException e) {
			System.out.println("File Not Found");
		}
	}
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(this.info.getProperty("DBDRIVER")); // Driver Loading
			conn = DriverManager.getConnection(
					this.info.getProperty("DBURL"),
					this.info.getProperty("DBUSER"),
					this.info.getProperty("DBPASSWD"));
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return conn;
	}

}
