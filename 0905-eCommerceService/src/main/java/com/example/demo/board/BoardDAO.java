package com.example.demo.board;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.member.Member;

@Repository
public interface BoardDAO extends JpaRepository<Board, Integer> {
	//작성자로 검색
	ArrayList<Board> findByWriter(Member writer);
	
	//타이틀(like) 검색
	ArrayList<Board> findByTitleLike(String title);
}	
