

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


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
