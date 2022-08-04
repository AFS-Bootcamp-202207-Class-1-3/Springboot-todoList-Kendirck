package com.example.todolist.mapper;

import com.example.todolist.entity.Todo;
import com.example.todolist.entity.TodoRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kendrick Chen
 * @Date: 2022/08/04/2:31 PM
 * @Mail: KENDRICK.CHEN@OOCL.COM
 */

@Component
public class TodoMapper {
    public Todo toEntity(TodoRequest todoRequest){
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoRequest, todo);
        return todo;
    }

}
