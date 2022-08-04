package com.example.todolist.service;

import com.example.todolist.entity.Todo;
import com.example.todolist.entity.TodoRequest;
import com.example.todolist.exception.NotFoundOneException;
import com.example.todolist.mapper.TodoMapper;
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

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo update(int id, Todo todo){
       Todo todoFine=todoRepository.findById(id).orElseThrow(() -> new NotFoundOneException(Todo.class.getName()));
        todoFine.merge(todo);
        return todoRepository.save(todoFine);
    }

    public void delete(Integer id) {
        todoRepository.deleteById(id);
    }
}
