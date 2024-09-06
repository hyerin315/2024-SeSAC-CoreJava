package com.example.demo.guestbook;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestBookService {
	@Autowired
	private GuestBookDAO dao;
	
	//글 작성 및 수정 (글 작성 및 수정은 구현부가 동일)
	//save() : 방금 추가/수정 된 행을 entity에 담아서 반환함
	public GuestBookDTO saveGuestBook(GuestBookDTO dto) {
		GuestBook entity = dao.save(new GuestBook(dto.getNum(), dto.getWriter(), dto.getWdate(), dto.getPwd(), dto.getContent()));
		return new GuestBookDTO(entity.getNum(), entity.getWriter(), entity.getWdate(), entity.getPwd(), entity.getContent());
	}
	
	//글 전체 목록
	public ArrayList<GuestBookDTO> getAll() {
		ArrayList<GuestBook> all = (ArrayList<GuestBook>) dao.findAll(); //전체 검색
		ArrayList<GuestBookDTO> list = new ArrayList<>();
		for (GuestBook entity : all) {
			list.add(new GuestBookDTO(entity.getNum(), entity.getWriter(), entity.getWdate(), entity.getPwd(), entity.getContent()));
		}
		return list;
	}
	
	//num 검색
	public GuestBookDTO getGuestBook(int num) {
		GuestBook entity = dao.findById(num).orElse(null);
		if(entity != null) {
			return new GuestBookDTO(entity.getNum(), entity.getWriter(), entity.getWdate(), entity.getPwd(), entity.getContent());
		}
		return null;
	}

	//글 삭제
	public void delGuestBook(int num) {
		dao.deleteById(num);
	}
	
	//작성자로 검색
	public ArrayList<GuestBookDTO> getByWriter(String writer) {
		ArrayList<GuestBook> all = dao.findByWriter(writer);
		ArrayList<GuestBookDTO> list = new ArrayList<>();
		for(GuestBook entity : all) {
			list.add(new GuestBookDTO(entity.getNum(), entity.getWriter(), entity.getWdate(), entity.getPwd(), entity.getContent()));
		}
		return list;
	}
}
