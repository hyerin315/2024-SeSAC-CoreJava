package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.users.Users;
import com.example.demo.users.UsersDAO;

//로그인 인증
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UsersDAO dao;
	
	@Override
	// loadUserByUsername : 검색된 결과를 UserDetails 담아서 전달하고 아닐 경우 오류 메세지를 반환
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users u = dao.findById(username)
		.orElseThrow(
		()->new UsernameNotFoundException("not found username"+username));
		System.out.println("userdetails service:"+u);
		return new UserDetailsImpl(u);
	}
}