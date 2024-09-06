package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDAO dao;
	
	//회원 추가 및 모든 컬럼 수정
	//1) return이 없을 경우
//	public void saveMember(MemberDTO m) {
//		dao.save(new Member(m.getId(), m.getPwd(), m.getName(), m.getEmail(), m.getType()));
//	}
	
	//2) return이 있는 경우
	//추가, 수정:모든 컬럼 수정
		public MemberDTO saveMember(MemberDTO m) { //service  & controller는 DTO에서 정보를 갖고옴
			Member entity = dao.save(new Member(m.getId(), m.getPwd(), m.getName(), m.getEmail(), m.getType())); //save는 파라미터를 entity로 받으므로 entity 형태로 반환
			return new MemberDTO(entity.getId(), entity.getPwd(), entity.getName(), entity.getEmail(), entity.getType());
		}
	
	//회원 검색하기
	public MemberDTO getMember(String id) {
		Member entity = dao.findById(id).orElse(null);
		if(entity != null) {
			return new MemberDTO(entity.getId(), entity.getPwd(), entity.getName(), entity.getEmail(), entity.getType());
		}
		return null;
	}

	//회원 삭제하기
	public void delMember(String id) {
		dao.deleteById(id);
	}
}
