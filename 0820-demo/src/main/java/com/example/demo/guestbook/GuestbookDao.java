package com.example.demo.guestbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import Conn.MysqlConnect;

@Repository
public class GuestbookDao {
	
	 private MysqlConnect dbconn;
	  
	 public GuestbookDao() { dbconn = MysqlConnect.getInstance(); }
	  
	 public Guestbook select(int num) { 
		 Connection conn = dbconn.getConn(); 
		 String sql = "select * from guestbook where id=?"; 
		 try{ 
			 PreparedStatement pstmt = conn.prepareStatement(sql); pstmt.setInt(1, num); 
			 ResultSet rs = pstmt.executeQuery(); 
			 if(rs.next()) { 
				 return new Guestbook(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)); } 
			 } catch (SQLException e) { 
				 e.printStackTrace(); 
		} finally { 
			 try { conn.close(); 
			 } catch (SQLException e) { 
				 e.printStackTrace(); }
			 } 
		 return null; 
		}
	 
	 
	 public ArrayList<Guestbook> selectAll() { 
		 ResultSet rs = null;
		 ArrayList<Guestbook> list = new ArrayList<>(); 
		 Connection conn = dbconn.getConn(); 
		 String sql = "select * from guestbook order by num"; 
		 try{
			 PreparedStatement pstmt = conn.prepareStatement(sql); 
			 rs = pstmt.executeQuery(); 
			 while (rs.next()) { 
				 list.add(new Guestbook(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5))); } 
			 } catch (SQLException e) { 
				 e.printStackTrace(); }
		 finally { 
			 try { conn.close(); 
			 } catch (SQLException e) { 
				 e.printStackTrace();}
			 } 
		 return list; 
		 }
	 
	 
     public void update(Guestbook guestbook) { 
    	 Connection conn = dbconn.getConn();
	     String sql = "update guestbook set content=? where writer=? pwd=?"; 
	     try{ 
	    	 PreparedStatement pstmt = conn.prepareStatement(sql); 
	    	 pstmt.setString(1, guestbook.getContent()); 
	    	 pstmt.setString(2, guestbook.getWriter());
	    	 pstmt.setString(3, guestbook.getPwd()); 
	    	 pstmt.executeUpdate(); 
	    	 } catch (SQLException e) { 
	    		 e.printStackTrace(); 
	    		 } finally { 
	    			 try {  
	    				 conn.close(); 
	    				 } catch (SQLException e) {
	    					 e.printStackTrace();
	    					 }
	    			 } 
	     }
     
     
     public void delete(int num) { 
    	 Connection conn = dbconn.getConn(); 
    	 String sql = "delete from guestbook where num=?"; 
    	 try{ 
    		 PreparedStatement pstmt = conn.prepareStatement(sql); 
    		 pstmt.setInt(1, num); 
    		 pstmt.executeUpdate(); 
    		 } catch (SQLException e) { 
    			 e.printStackTrace(); 
    			 } finally { 
    				 try { 
    					 conn.close();
    					 } catch (SQLException e) { 
    						 e.printStackTrace(); 
    						 }
    				 } 
     }
    	 
     
     public String getPwdByWriter(String writer) { // DB에서 비밀번호를 가져오는 쿼리와 로직을 작성
    	 String sql = "SELECT pwd FROM guestbook WHERE writer = ?"; 
    	 try (
    			 Connection conn = dbconn.getConn(); 
    			 PreparedStatement pstmt = conn.prepareStatement(sql)
    	){ 
    		 pstmt.setString(1, writer); 
    		 try (ResultSet rs = pstmt.executeQuery()) { 
    			 if (rs.next()) { 
    				 return rs.getString("pwd"); 
    				 } 
    			 } 
    		 } catch (SQLException e) { 
    			 e.printStackTrace(); 
    			 } 
    		 return null; 
    		}
     
    
     public void insert(Guestbook guestbook) { 
    	 Connection conn = dbconn.getConn();
    	 String sql = "insert into guestbook(writer, pwd, content) values(?,?,?);";
    	 try{ 
    		 PreparedStatement pstmt = conn.prepareStatement(sql); 
    		 pstmt.setString(1,guestbook.getWriter()); 
    		 pstmt.setString(2, guestbook.getPwd()); 
    		 pstmt.setString(3, guestbook.getContent()); 
    		 pstmt.executeLargeUpdate(); 
    		 } catch (SQLException e) { 
    			 e.printStackTrace(); 
    			 } 
    	 finally { 
    		 try { 
    			 conn.close();
    			 } catch (SQLException e) { 
    				 e.printStackTrace(); 
    				 }
    		 } 
    	 }


}
