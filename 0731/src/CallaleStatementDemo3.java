import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

//SQL - StoredProcedure 사용하기

/*MySQL Code

DELIMITER $$
CREATE PROCEDURE sp_insertDept
(
	IN v_deptno		TINYINT,
    IN v_dname		VARCHAR(14),
    IN v_loc		VARCHAR(13)
)
BEGIN
	INSERT INTO dept_clone(deptno, dname, loc)
    VALUES (v_deptno, v_dname, v_loc);
    COMMIT; # insert는 DML이며, DML은 트랜잭션이 필요함
END
$$
DELIMITER ;

 */
public class CallaleStatementDemo3 {
	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		
		DBConnection dbConn = new DBConnection();
		Connection conn = dbConn.getConnection(); // 1~3단계
		String sql = "{ call sp_insertDept(?, ?, ?) }"; //불완전한 SQL 문장
		CallableStatement cstmt = null;
		try {
		    cstmt = conn.prepareCall(sql); // 4단계 
		    System.out.print("부서 번호 : ");
		    int deptno = scan.nextInt();
		    		
		    System.out.print("부서 이름 : ");
		    String dname = scan.next();
		    
		    System.out.print("부서 위치 : ");
		    String loc = scan.next();
		    
		    //완전한 SQL문장
		    cstmt.setInt(1, deptno);
		    cstmt.setString(2, dname);
		    cstmt.setString(3, loc);

			cstmt.execute(); // 5단계
			System.out.println("새 레코드 삽입 성공");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("새 레코드 삽입 실패");
		}
		DBClose.dbClose(conn, cstmt); // 7단계
	}
}
