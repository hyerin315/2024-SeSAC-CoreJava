package com.example.demo.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.member.Member;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao;
	
	// 추가 및 수정
	public void saveBoard(BoardDTO dto) {
		dao.save(new Board(dto.getNum(), dto.getWriter(), dto.getWdate(), dto.getTitle(), dto.getContent()));
	}
	
	// 글 검색
	public BoardDTO getBoard(int num) {
		Board b = dao.findById(num).orElse(null);// b : entity
		if(b != null) {
			return new BoardDTO(b.getNum(), b.getWriter(), b.getWdate(), b.getTitle(), b.getContent());
		}
		return null;
	}

	// 전체 검색
	public ArrayList<BoardDTO> getAll() {
		List<Board> all = dao.findAll();
		ArrayList<BoardDTO> list = new ArrayList<>();
		for(Board b : all) {
			list.add(new BoardDTO(b.getNum(), b.getWriter(), b.getWdate(), b.getTitle(), b.getContent()));
		}
		return list;
	}
	
	// 타이틀로 검색
	public ArrayList<BoardDTO> getByTitle(String title) {
		List<Board> all = dao.findByTitleLike("%"+title+"%");
		ArrayList<BoardDTO> list = new ArrayList<>();
		for(Board b:all) {
			list.add(new BoardDTO(b.getNum(), b.getWriter(), b.getWdate(), b.getTitle(), b.getContent()));
		}
		return list;		
	}
	
	// 작성자로 검색
	public ArrayList<BoardDTO> getByWriter(String writer) {
		List<Board> all = dao.findByWriter(new Member(writer, "", "", "", ""));
		ArrayList<BoardDTO> list = new ArrayList<>();
		for(Board b:all) {
			list.add(new BoardDTO(b.getNum(), b.getWriter(), b.getWdate(), b.getTitle(), b.getContent()));
		}
		return list;
	}
	
	public void delBoard(int num) {
		dao.deleteById(num);
	}
}
