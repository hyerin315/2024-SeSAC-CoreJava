package com.example.demo.todo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.user.User;

public interface TodoDAO extends JpaRepository<Todo, Integer> {
    // ID로 검색
    ArrayList<Todo> findById(User id);
}
