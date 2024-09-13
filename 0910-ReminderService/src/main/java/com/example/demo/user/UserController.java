package com.example.demo.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.auth.TokenProvider;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private TokenProvider provider;

    @Autowired
    private AuthenticationManagerBuilder abuilder;

    // 멤버 추가
    @PostMapping("/join")
    public Map join(UserDTO userDTO) {
        System.out.println(userDTO);
        boolean flag = true;
        try {
            service.saveUser(userDTO);
        } catch (Exception e) {
            flag = false;
            System.out.println(e);
        }
        Map map = new HashMap();
        map.put("flag", flag);
        return map;
    }

    //로그인
    @PostMapping("/login")
    public Map login(String username, String password) {
        UsernamePasswordAuthenticationToken authtoken =
            new UsernamePasswordAuthenticationToken(username, password);
        Authentication auth =
            abuilder.getObject().authenticate(authtoken);
        boolean flag = auth.isAuthenticated(); //인증 결과
        System.out.println("인증결과:" + flag);
        Map map = new HashMap();
        if(flag) { //정상 인증
            UserDTO user = service.getUser(username);
            System.out.println(user);
            String token = provider.getToken(user);
            System.out.println(token);
            map.put("token", token);
        } else {
            System.out.println("비정상 응답");
        }
        map.put("flag", flag);
        return map;
    }

    @DeleteMapping("/{username}")
    public Map delete(@PathVariable("username") String username) {
        Map map = new HashMap();
        boolean flag = true;
        try{
            service.delUser(username);
        } catch (Exception e) {
            System.out.println(e);
            flag = false;
        }
        map.put("flag", flag);
        return map;
    }

    @GetMapping("/auth/userInfo")
    public Map info() {
        Map map = new HashMap();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); //username 추출
        UserDTO userDTO = service.getUser(username);
        map.put("dto", userDTO);
        return map;
    }
}
