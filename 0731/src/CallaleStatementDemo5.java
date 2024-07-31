import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

//SQL - StoredProcedure 사용하기
//부서 번호로 소속 사원의 사원번호, 사원명, 부서명, 부서위치

/*MySQL Code

DELIMITER //
CREATE PROCEDURE sp_select_emp_dept
(
	IN 		v_deptno	TINYINT
)
BEGIN
	SELECT  empno, ename, dname, loc, dept.deptno
	FROM	emp  NATURAL JOIN	 dept
    WHERE	deptno = v_deptno;
END
//
DELIMITER ;

 */
public class CallaleStatementDemo5 {
	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		
		DBConnection dbConn = new DBConnection();
		Connection conn = dbConn.getConnection(); // 1~3단계
		String sql = "{ call sp_selectDname(?) }"; //불완전한 SQL 문장
		CallableStatement cstmt = null;
		try {
		    cstmt = conn.prepareCall(sql); // 4단계 
		    
		    System.out.print("부서 이름 : ");
		    String dname = scan.next();
		    
		    cstmt.setString(1, dname);
		    // INOUT은 동시에 resisterOutParameter()도 사용해야함
		    cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
		    cstmt.execute();
		    System.out.printf("%s의 위치는 %s입니다. %n",
		    		dname, cstmt.getString(1));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("실패");
		}
		DBClose.dbClose(conn, cstmt); // 7단계
	}
}
