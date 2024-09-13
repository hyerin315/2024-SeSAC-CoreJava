package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDAO dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //추가 및 수정
    public void saveUser(UserDTO userDTO) {
        dao.save(new User(userDTO.getId(), userDTO.getUsername(), passwordEncoder.encode(userDTO.getPassword()), userDTO.getName(), userDTO.getEmail() ));
    }

    // 회원 검색하기
    public UserDTO getUser(String username) {
        User userEntity = dao.findByUsername(username).orElse(null);
        if (userEntity != null) {
            return new UserDTO(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword(), userEntity.getName(), userEntity.getEmail());
        }
        return null;
    }

    // 회원 삭제
    public void delUser(String user) {
        dao.deleteById(user);
    }

}
