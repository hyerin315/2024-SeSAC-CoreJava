package com.example.demo.guestbook;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestBookDAO extends JpaRepository<GuestBook, Integer> { //JpaRepository에 기본적인 구성이 포함되어 있어 자동으로 구현됨
	ArrayList<GuestBook> findByWriter(String writer);
}


