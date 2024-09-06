package com.example.demo.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.users.Users;
import com.example.demo.users.UsersDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//UserDetails 구현체
//: 인증 정보를 담는 VO (Id, Pwd)
public class UserDetailsImpl implements UserDetails {

	private final Users u;
	
	public UserDetailsImpl(Users u) {
		this.u = u;
	}

	//User의 권한 정보 설정 : 권한이 여러개일 수 있으므로 List로 담음
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		//권한 정보 확인
		list.add(new SimpleGrantedAuthority(u.getType()));
		return list;
	}

	@Override
	public String getPassword() {
		return u.getPwd();
	}

	@Override
	public String getUsername() {
		return u.getId();
	}
	
	@Override
	public boolean isAccountNonExpired() { //모두 허용할 경우 true로 지정
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
