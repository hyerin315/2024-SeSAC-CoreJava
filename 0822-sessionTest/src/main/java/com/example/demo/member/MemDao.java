package com.example.demo.member;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MemDao {
	@Autowired
	private JdbcTemplate temp;
	
	public class MemberResultMap implements RowMapper<Member> {
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}
	}
	
	//고객 정보 추가
	public void insert(Member mb) {
		String sql = "insert into member values(?, ?, ?, ?, ?)";
		temp.update(sql, new Object[] {mb.getId(), mb.getPwd(), mb.getName(), mb.getEmail(), mb.getType()});
	}
	
	
	//고객 정보 수정
	public void update(Member mb) {
		String sql = "update member set name=?, email=?, type=? where id-?";
		temp.update(sql, new Object[] {mb.getName(), mb.getEmail(), mb.getType(), mb.getId()});
	}
	
	//고객 정보 삭제
	public void delete(String id) {
		String sql = "delete from member where id=?";
		temp.update(sql, id);
	}
	
	//고객 정보 검색
	public Member select(String id) {
		String sql = "select * from member where id=?";
		Member mb = null;
		try {
			mb = temp.queryForObject(sql, new MemberResultMap(), id);
		}catch (Exception e) {
			System.out.println(e);
		}
		return mb;
	}
	
		
}

