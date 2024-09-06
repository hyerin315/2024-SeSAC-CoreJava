package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	@Autowired
	private UsersDAO dao;
	
	@Autowired
	private PasswordEncoder encoder;
	
	//추가 및 수정
	public void save(UsersDTO dto) {
		dao.save(new Users(dto.getId(), encoder.encode(dto.getPwd()), dto.getName(), dto.getEmail(), dto.getType()));
	}
	
	//pk 검색
	public UsersDTO get(String id) {
		Users entity = dao.findById(id).orElse(null);
		if(entity != null) {
			return new UsersDTO(entity.getId(), entity.getPwd(), entity.getName(), entity.getEmail(), entity.getType());
		}
		return null;
	}
	
	//삭제
	public void del(String id) {
		dao.deleteById(id);
	}
}
