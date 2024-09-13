package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.user.User;
import com.example.demo.user.UserDAO;

//로그인 인증
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDAO dao;
	
	@Override
	// loadUserByUsername : 검색된 결과를 UserDetails 담아서 전달하고 아닐 경우 오류 메세지를 반환
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = dao.findByUsername(username).orElse(null);
		if (u == null) {
			throw new UsernameNotFoundException("User not found");
		}

		System.out.println("userdetails service:"+u);
		return new UserDetailsImpl(u);
	}
}
