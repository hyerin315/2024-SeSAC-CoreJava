package com.example.demo.todo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.auth.UserDetailsImpl;
import com.example.demo.user.User;
import com.example.demo.user.UserDTO;

@RestController
@CrossOrigin(origins = "*")
public class TodoController {
    @Autowired
    private TodoService service;

    // todo 작성
    @PostMapping("/addTodo")
    public Map add(TodoDTO todoDTO, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        boolean flag = false;
        User user = userDetails.getU();
        try {
            todoDTO.setUser(user);
            service.saveTodo(todoDTO);
            flag = true;
        } catch (IllegalStateException e) {
            System.err.println("IllegalStateException occurred: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
        Map map = new HashMap();
        map.put("flag", flag);
        return map;
    }

    // todo 수정
    @PutMapping("/editTodo")
    public Map edit(TodoDTO todo) {
        Map map = new HashMap();
        TodoDTO oldTodo = service.getTodo(todo.getId());
        oldTodo.setTodo(todo.getTodo());
        boolean flag = true;
        try {
            service.saveTodo(oldTodo);
        } catch (Exception e) {
            System.out.println(e);
            flag = false;
        }
        map.put("flag", flag);
        return map;
    }

    // //전체검색
    // @GetMapping("/todo")
    // public Map getByUsername() {
    //     Map map = new HashMap();
    //     map.put("list", service.getAllTodo());
    //     return map;
    // }

    //작성자로 검색
    @GetMapping("/todo/{id}")
    public Map getbyUsername(@PathVariable("id") int id) {
        Map map = new HashMap();
        ArrayList<TodoDTO> dto = service.getById(id);
        map.put("dto", dto);
        return map;
    }

    // 글 삭제
    @DeleteMapping("/todo/{id}")
    public Map delete(@PathVariable("id") int id) {
        Map map = new HashMap();
        boolean flag = true;
        try {
            service.delTodo(id);
        } catch (Exception e) {
            System.out.println(e);
            flag = false;
        }
        map.put("flag", flag);
        return map;
    }
}
