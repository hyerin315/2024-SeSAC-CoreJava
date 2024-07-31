import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

//SQL - StoredProcedure 사용하기
//사원 이름을 입력받아서 부서 이름과 부서 위치를 출력하시오

/*MySQL Code

DELIMITER $$
CREATE PROCEDURE sp_selectEMP
(
	IN v_empno	 	SMALLINT,
    OUT v_dname 	VARCHAR(14),
    OUT v_loc       VARCHAR(13)
)
BEGIN
	SELECT dname, loc INTO v_dname, v_loc
	FROM emp JOIN dept ON (emp.deptno = dept.deptno)
    WHERE emptno = v_empno;
END
$$
DELIMITER ;

 */
public class CallaleStatementDemo4 {
	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		
		DBConnection dbConn = new DBConnection();
		Connection conn = dbConn.getConnection(); // 1~3단계
		String sql = "{ call sp_insertDept(?, ?, ?) }"; //불완전한 SQL 문장
		CallableStatement cstmt = null;
		try {
		    cstmt = conn.prepareCall(sql); // 4단계 
		    System.out.print("사원 번호 : ");
		    int empno = scan.nextInt();
		    		
		    cstmt.registerOutParameter(2,  java.sql.Types.VARCHAR);
		    cstmt.registerOutParameter(3,  java.sql.Types.VARCHAR); //완전한 SQL 문장
		    cstmt.execute(); // 5단계
		    System.out.printf("부서명 : %s, 부서위치 : %s%n",
		    		cstmt.getString(2), cstmt.getString(3));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("실패");
		}
		DBClose.dbClose(conn, cstmt); // 7단계
	}
}
