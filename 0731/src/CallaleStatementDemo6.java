import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

//SQL - StoredProcedure 사용하기
//부서 이름으로 부서 위치를 출력하는 StoredProcedure
//특정 파라미터의 특정 값을 가져올 때면 값을 가져오나
//여러개의 것을 가져올 땐 한 번에 가져옴


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
public class CallaleStatementDemo6 {
	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		
		DBConnection dbConn = new DBConnection();
		Connection conn = dbConn.getConnection(); // 1~3단계
		String sql = "{ call sp_select_emp_dept(?) }"; //불완전한 SQL 문장
        // 오라클은 { ? = call select_emp_dept} 도 됨
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
		    cstmt = conn.prepareCall(sql); // 4단계 
		    
		    System.out.print("부서 번호 : ");
		    int deptno = scan.nextInt();
		 
		    cstmt.setInt(1, deptno); //완전한 SQL 문장
		    rs = cstmt.executeQuery(); // excuteQuery : ResultSet으로 값을 반환받아야할 때만 사용 *오라클에선 사용 X
		    boolean flag = rs.next();
		    if(!flag) { //레코드가 하나도 없다면
		    	System.out.println("조건에 맞는 결과값이 없습니다.");
		    } else { //한 개라도 있다면
		    	do { 
		    		System.out.printf("%d\t%s\t%s\t%s%n",
		    				rs.getInt("empno"), rs.getString("ename"),
		    				rs.getString("dname"), rs.getString("loc") );
		    		
		    	} while (rs.next());
		    }
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("실패");
		}
		DBClose.dbClose(conn, cstmt, rs); // 7단계
	}
}
