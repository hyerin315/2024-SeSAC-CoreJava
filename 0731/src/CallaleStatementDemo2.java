import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

//SQL - StoredProcedure 사용하기
//보통 파라미터 있는 경우를 더 많이 사용함

/*MySQL Code

DELIMITER //
CREATE PROCEDURE sp_deleteDept()
BEGIN
	DELETE FROM dept_clone;
END
//
DELIMITER ;

 */
public class CallaleStatementDemo2 {
	public static void main(String[] args) throws SQLException {
		DBConnection dbConn = new DBConnection();
		Connection conn = dbConn.getConnection(); // 1~3단계
		String sql = "{ call sp_deleteDept()}"; // 4단계
		CallableStatement cstmt = null;
		try {
		    cstmt = conn.prepareCall(sql);
			cstmt.execute(); // 5단계
			System.out.println("삭제 성공");
		} catch (SQLException ex) { 
			System.out.println("삭제 실패");
		}
		DBClose.dbClose(conn, cstmt); // 7단계
	}
}
