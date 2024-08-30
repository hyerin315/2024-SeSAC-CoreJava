package com.example.demo.article;

import java.util.ArrayList;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface ArticleDAO extends JpaRepository<Article, Integer> {
	//제목으로 검색
	ArrayList<Article> findByTitleLike(String title);

	//확장자명으로 검색
	ArrayList<Article> findByDataLike(String data);
	
	@Transactional
    @Modifying
    @Query(value="update imgboard2 set cnt=cnt+1 where num=:num", nativeQuery=true)
    void updateCnt(@Param("num") int num);
}
