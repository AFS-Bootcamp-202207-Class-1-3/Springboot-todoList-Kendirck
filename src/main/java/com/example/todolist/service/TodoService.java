package com.example.todolist.service;

import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kendrick Chen
 * @Date: 2022/08/04/1:31 PM
 * @Mail: KENDRICK.CHEN@OOCL.COM
 */
@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;
    public List<Todo> getAll(){
        return todoRepository.findAll();
    }
}
