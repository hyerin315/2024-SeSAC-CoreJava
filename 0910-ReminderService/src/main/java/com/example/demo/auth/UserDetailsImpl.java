package com.example.demo.auth;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.user.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//UserDetails 구현체
//: 인증 정보를 담는 VO (Id, Pwd)
public class UserDetailsImpl implements UserDetails {

	private final User u;

	public UserDetailsImpl(User u) {
		this.u = u;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of();
	}

	@Override
	public String getPassword() {
		return u.getPassword();
	}

	@Override
	public String getUsername() {
		return u.getUsername();
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
