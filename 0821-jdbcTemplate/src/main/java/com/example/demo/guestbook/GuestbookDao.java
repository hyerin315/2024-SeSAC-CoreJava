package com.example.demo.guestbook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GuestbookDao {
	@Autowired
	//사용할 jdbcTemplate 객체 의존성 주입
	private JdbcTemplate temp;
	
	//resultMap 정의
	public class GuestResultMap implements RowMapper<Guestbook> {

		//ResultSet의 한 탭을 처리, 파람으로 처리해야할 번호를 받음
	    //각 컬럼을 VO(객체) 생성자 파일에 매핑
		@Override
		public Guestbook mapRow(ResultSet rs, int rowNum) throws SQLException { //mapRow 검색된 결과 만큼 각 행의 값 호출을 반복함, 어느 생성자에 어떤 값을 넣어야하는지 / Guestbook 빨간줄 : addUncomplate - 자동으로 넣어줘야할 겂을 넣어줌
			return new Guestbook(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5)); //jdbctemplate에서는 한 줄만 작성하면 알아서 처리
		}
		
	}
	
	// 방명록 작성
	public void insert(Guestbook gb) {
		String sql = "insert into guestbook(writer, pwd, wdate, content) values(?, ?, sysdate(), ?)";
		temp.update(sql, new Object[] {gb.getWriter(), gb.getPwd(), gb.getContent()}); // 물음표가 여러개라면 배열을 만들어서 넣어줌
	}
	
	
	// 방명록 검색
	public Guestbook select(int num) {
		String sql = "select * from guestbook where num=?";
		Guestbook gb = null;
		try {
			// queryForObject : 한 줄 검색
			gb = temp.queryForObject(sql, new GuestResultMap(), num);
		}catch (Exception e) {
			System.out.println(e);
		}
		return gb;
	}
	
	// 방명록 목록
	public ArrayList<Guestbook> selectAll() {
		String sql = "select * from guestbook order by num";
		return (ArrayList<Guestbook>) temp.query(sql, new GuestResultMap()); //ArrayList로 cast 
	}
	
	// 방명록 수정
	public void update(Guestbook gb) {
		String sql = "update guestbook set content=? where num=?";
		temp.update(sql, new Object[] { gb.getContent(), gb.getNum()});
	}

	// 방명록 삭제
	public void delete(int num) {
		String sql = "delete from guestbook where num=?";
		temp.update(sql, num);
	}
	

}
