package com.example.demo.todo;

import java.util.Date;

import com.example.demo.user.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
    private int id;
    private User user;
    private Date todoDate;
    private String todo;
    private boolean checked;
}
