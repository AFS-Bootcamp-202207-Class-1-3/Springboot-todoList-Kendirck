package com.example.todolist.controller;

import com.example.todolist.entity.Todo;
import com.example.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kendrick Chen
 * @Date: 2022/08/04/1:29 PM
 * @Mail: KENDRICK.CHEN@OOCL.COM
 */

@RestController
@RequestMapping("todos")
@CrossOrigin("*")
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping
    public List<Todo> getAll(){
        return todoService.getAll();
    }
}
