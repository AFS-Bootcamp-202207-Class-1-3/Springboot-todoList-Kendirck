package com.example.todolist.controller;

import com.example.todolist.entity.Todo;
import com.example.todolist.entity.TodoRequest;
import com.example.todolist.mapper.TodoMapper;
import com.example.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    TodoMapper todoMapper;

    @GetMapping
    public List<Todo> getAll(){
        return todoService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo addTodo(@RequestBody TodoRequest todoRequest){
        return todoService.addTodo(todoMapper.toEntity(todoRequest));
    }

    @PutMapping("/{id}")
    public Todo updateEmployee(@PathVariable Integer id, @RequestBody TodoRequest todoRequest) {
        return todoService.update(id, todoMapper.toEntity(todoRequest));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        todoService.delete(id);
    }
}
