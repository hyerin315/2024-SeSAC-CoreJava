package com.example.demo.users;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.auth.TokenProvider;

@RestController
@CrossOrigin(origins="*")
public class UserController {
	@Autowired
	private UsersService service;
	
	@Autowired
	private TokenProvider provider;
	
	@Autowired
	private AuthenticationManagerBuilder abuilder;
	
	@PostMapping("/join")
	public Map join(UsersDTO dto) {
		boolean flag = true;
		try {
			service.save(dto);
		} catch (Exception e) {
			flag = false;
			System.out.println(e);
		}
		Map map = new HashMap();
		map.put("flag", flag);
		return map;
	}
	
	@PostMapping("/login")
	public Map login(String id, String pwd) {
		UsernamePasswordAuthenticationToken authtoken =
				new UsernamePasswordAuthenticationToken(id, pwd);
		Authentication auth = 
				abuilder.getObject().authenticate(authtoken);
		boolean flag = auth.isAuthenticated(); //인증 결과
		System.out.println("인증결과:" + flag);
		Map map = new HashMap();
		if(flag) { //정상 인증
			String token = provider.getToken(service.get(id));
			map.put("token", token);
		}
		map.put("flag", flag);
		return map;
	}
	
	@GetMapping("/auth/meminfo")
	public Map info() {
		Map map = new HashMap();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String id = auth.getName(); //username 추출
		UsersDTO dto = service.get(id);
		map.put("dto", dto);
		return map;
	}

}
