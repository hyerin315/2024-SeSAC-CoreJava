package com.example.demo.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;
	
	public void addBoard(Board b) {
		dao.insert(b);
	}
	
	public Board getBoard(int num) {
		return dao.select(num);
	}
	
	public ArrayList<Board> getAll(){
		return dao.selectAll();
	}
	
	public ArrayList<Board> getByTitle(String title){
		return dao.selectByTitle("%"+title+"%");
	}
	
	public ArrayList<Board> getByWriter(String writer){
		return dao.selectByWriter(writer);
	}
	
	public void editBoard(Board b) {
		dao.update(b);
	}
	
	public void delBoard(int num) {
		dao.delete(num);
	}
}
