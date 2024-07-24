// 7단계
// 1. import 하자 - java.sql.*
// 2. MySQL Driver Loading 하자
// 3. Memory에 loading된 MySQL Driver를 이용하여 Connection 하자
// 4. Statement 객체 생성
// 5. Statement 객체를 이용하여 sql 실행
// 6. ResultSet의 결과를 parhing 하자
// 7. 반드시 close해야한다

import java.sql.*;

public class JDBCDemo {
	public static void main(String[] args) {
		// MySQL Driver Loading - Connector J (Java용 드라이버) :DBMS 제조사에서 다운 받아야함
		// Java의 Driver manager가 Driver 제어권을 가져감
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class Founded");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		} // 메모리에 인스턴스화
		
		
		String url = "jdbc:mysql://localhost:3306/mycompany"; //jdbc는 URL이 jdbc로, 어떤 SQL, 포트번호, 어떤 SQL사용하는지
		Connection conn = null;
		// 로딩 방법 
		// 1. forname : 클래스 이름을 스트링으로 
		// 2. registerDriver : 드라이버로 로딩
		try {
			conn = DriverManager.getConnection(url, "root", "mymysql");
			System.out.println("Connection Success");
		} catch (SQLException e) {
			System.out.println("Connection Failure");
		}// url만 쓰는 경우 : ID, PW를 안쓸 때
		
		
		//Statement 객체 생성
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Statement 객체를 이용하여 sql 실행
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery("SELECT now(), version()");
		} catch (SQLException e) {
			System.out.println("Query Syntax Error");
		} //SELECT용
	
		//ResultSet의 결과를 parhing 하자
		try {
			rs.next(); // 포인터가 한 줄 밑으로 내려옴 (한 줄 째로 읽어서 실행)
			String now = rs.getString(1); //now() / JDBC는 인덱스가 1부터 시작
			String version = rs.getString(2);
			System.out.println(now + ", " + version);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		// close 하기
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn  != null) conn.close();
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
}
