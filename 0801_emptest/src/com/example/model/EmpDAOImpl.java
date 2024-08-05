package com.example.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;


/*
 * Author : Jinhee Lim(createEmp()), Hyerin Lim(readAllEmp())
 * When : Aug, 01, 2024
 * Objective : 데이터베이스와 실제로 상호작용하며 사원 데이타를 등록하고 반환하는 DAOImpl 객체입니다.
 * Environment : Windows 10 22H2(OS build 19045.4651), openjdk 17.0.11, IntelliJ 2024.1.4
 */


public class EmpDAOImpl implements EmpDAO {
	private Connection conn;
	
	public EmpDAOImpl() {
		DBConnection dbConn = new DBConnection();
		this.conn = dbConn.getConnection(); //1~3단계
	}
	
	// 데이타 입력하기
	@Override
    public boolean createEmp(EmpVO e) throws SQLException {
        String sql = "{CALL insert_emp(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        CallableStatement stmt = conn.prepareCall(sql);
        System.out.println(sql.toString());
        stmt.setString(1, e.getEmpno());
        stmt.setString(2, e.getEname());
        stmt.setString(3, e.getDname());
        stmt.setInt(4, e.getSal());
        stmt.setInt(5,e.getN_time());
        stmt.setInt(6, e.getFam());
        stmt.setInt(7, e.getHo_sal());
        stmt.setInt(8, e.getFam_sal());
        stmt.setInt(9, e.getN_sal());
        stmt.setInt(10, e.getTotal());
        stmt.setInt(11, e.getNet_amount());
        int su = stmt.executeUpdate(); // 5단계
        DBClose.dbClose(this.conn, stmt);
        return (su == 1) ? true : false;
    }
    


	// 모든 데이타 출력하기
	@Override
	public List<EmpVO> readAllEmp() throws SQLException{
		
		String sql = "{ call select_all_emp() }";
		
		CallableStatement stmt = this.conn.prepareCall(sql); //4단계
		ResultSet rs = stmt.executeQuery(); //5단계
		boolean flag = rs.next();
		List<EmpVO> list = new ArrayList<EmpVO>(); //capacity 10개 생성
		if(!flag) { 
			//  한번도 add()를 하지 않아서 결국 list.size() == 0
		} else { 
				do {// 6단계
					String empno = rs.getString("empno");
					String ename = rs.getString("ename");
					String dname = rs.getString("dname");
					int sal = rs.getInt("sal");
					int ho_sal = rs.getInt("ho_sal");
					int fam_sal = rs.getInt("fam_sal");
					int n_sal = rs.getInt("total");
					int netamount = rs.getInt("netamount");
					
					EmpVO e = new EmpVO();
					e.setEmpno(empno);
					e.setEname(ename);
					e.setDname(dname);
					e.setSal(sal);
					e.setHo_sal(ho_sal);
					e.setFam_sal(fam_sal);
					e.setN_sal(n_sal);
					e.setNet_amount(netamount);
					list.add(e);
				}while (rs.next());
		}
		DBClose.dbClose(conn, stmt, rs); //7단계
		return list;
	}

}
