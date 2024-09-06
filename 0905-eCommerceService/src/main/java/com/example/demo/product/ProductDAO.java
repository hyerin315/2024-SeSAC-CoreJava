package com.example.demo.product;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.member.Member;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {
	//판매자로 찾기
	ArrayList<Product> findBySeller(Member seller);
	
	//이름으로 찾기
	ArrayList<Product> findByNameLike(String name);
	
	//가격으로 찾기
	ArrayList<Product> findByPriceBetween(int p1, int p2); //p1과 p2 사이의 가격을 찾아줌
}
