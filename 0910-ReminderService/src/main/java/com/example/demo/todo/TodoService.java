package com.example.demo.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.user.User;
import com.example.demo.user.UserDAO;
import com.example.demo.user.UserDTO;

@Service
public class TodoService {
    @Autowired
    private TodoDAO todoDAO;

    @Autowired
    private UserDAO memberDAO;

    // todo 추가
    public void saveTodo(TodoDTO todoDTO) {
        todoDAO.save(new Todo(todoDTO.getId(), todoDTO.getUser(), todoDTO.getTodoDate(), todoDTO.getTodo(), false));
    }

    // todo 삭제
    public void delTodo(int id) {
        todoDAO.deleteById(id);
    }

    // todo 번호로 검색
    public TodoDTO getTodo(int id) {
        Todo todo = todoDAO.findById(id).orElse(null);
        if(todo != null) {
            return new TodoDTO(todo.getId(), todo.getUser(), todo.getTodoDate(), todo.getTodo(), false);
        }
        return null;
    }

    // 작성자로 검색
    public ArrayList<TodoDTO> getById(int id) {
        List<Todo> todoDAOById = todoDAO.findById(new User(id, "", "", "", ""));
        ArrayList<TodoDTO> list = new ArrayList<>();
        for(Todo todo : todoDAOById) {
            list.add(new TodoDTO(todo.getId(), todo.getUser(), todo.getTodoDate(), todo.getTodo(), false));
        }
        return list;
    }

    // 전체 검색
    public ArrayList<TodoDTO> getAllTodo(){
        List<Todo> todoDAOAll = todoDAO.findAll();
        ArrayList<TodoDTO> list = new ArrayList<>();
        for(Todo todo : todoDAOAll) {
            list.add(new TodoDTO(todo.getId(), todo.getUser(), todo.getTodoDate(), todo.getTodo(), false));
        }
        return list;
    }
}
