import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

//SQL - StoredProcedure 사용하기

/*MySQL Code

DELIMITER //
CREATE PROCEDURE sp_test()
BEGIN 
	SELECT now(), version();
END
//
DELIMITER ;

CALL sp_test();

 */
public class CallaleStatementDemo {
	public static void main(String[] args) throws SQLException {
		DBConnection dbConn = new DBConnection();
		Connection conn = dbConn.getConnection(); // 1~3단계
		String sql = "{ call sp_test(?, ?) }"; // (? : now / ? : version) 미완성 SQL 문장 -> 완성이 되려면 ?를 채워야함
		CallableStatement cstmt = conn.prepareCall(sql); // 4단계
		
		// IN Parameter는 setXxx()를 사용하고,
		// OUT Parameter는 resisterOutParameter()를 사용한다.
		// INOUT Parameter는 setXxx(), resisterOutParameter()를 사용한다. (둘다 사용)
		cstmt.registerOutParameter(1, java.sql.Types.DATE); // 아웃 파라미터를 등록 -> 완전한 SQL문장, DB는 1부터 시작하기 때문에 1부터 시작
		cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
		cstmt.execute(); // 5단계, Oracle : excuteUpdate / MySQL : excuteQuery를 사용하나 execute를 사용해도 됨
		System.out.println(cstmt.getDate(1));
		System.out.println(cstmt.getString(2));
		DBClose.dbClose(conn, null); // 7단계
	}
}
