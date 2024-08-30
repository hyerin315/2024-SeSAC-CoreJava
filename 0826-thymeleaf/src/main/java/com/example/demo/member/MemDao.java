package com.example.demo.member;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemDao {
	@Insert("insert into member values(#{id},#{pwd},#{name},#{email},#{type})")
	void insert(Member b);
	
	@Select("select * from member where id=#{id}")
	Member select(@Param("id") String id);
	
	@Update("update member set name=#{name}, email=#{email}, type=#{type} where id=#{id}")
	void update(Member b);
	
	@Delete("delete from member where id=#{id}")
	void delete(@Param("id") String id);
}
