package com.example.demo.imgboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.users.Users;

public interface ImgboardDAO extends JpaRepository<Imgboard, Integer> {

	//작성자로 검색
	ArrayList<Imgboard> findByWriter(Users writer);
	
	//타이틀(like) 검색
	ArrayList<Imgboard> findByTitleLike(String title);
	
	//가격대로 찾기
	List<Imgboard> findByPriceBetween(double minPrice, double maxPrice);
}
