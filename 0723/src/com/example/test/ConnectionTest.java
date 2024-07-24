package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.DBClose;
import com.example.DBConnection;

//test 코드는 main이 아닌 별도의 공간에서 test 해야함
class ConnectionTest {
	private Connection conn;
	
	@BeforeEach
	void init() {
		DBConnection dbconn = new DBConnection();		
		this.conn = dbconn.getConnection();
	}
	
	@Test
	void test() {
		assertNotNull(this.conn);
	} 
	
	@AfterEach
	void close() {
		DBClose.dbClose(this.conn);
	}

}
