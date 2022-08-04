package com.example.todolist;

import com.example.todolist.entity.Todo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void should_return_todos_when_get_all_todos() throws Exception {
        Todo todo = new Todo(1, "first to do item", true);
        mockMvc.perform(MockMvcRequestBuilders.get("/todos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(todo.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].context").value(todo.getContext()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].done").value(todo.getDone()));
    }

    @Test
    public void should_return_todo_when_post_given_new_todo() throws Exception {
        Todo todo = new Todo(null, "测试新增的text", true);
        ObjectMapper objectMapper = new ObjectMapper();
        String newTodo = objectMapper.writeValueAsString(todo);

        mockMvc.perform(MockMvcRequestBuilders.post("/todos")
                        .contentType(MediaType.APPLICATION_JSON).content(newTodo))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.context").value(todo.getContext()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.done").value(todo.getDone()));
    }

    @Test
    public void should_return_todo_when_put_given_todo() throws Exception{
        Todo todo = new Todo(6, "修改id为1的text", true);
        ObjectMapper objectMapper = new ObjectMapper();
        String oldTodo = objectMapper.writeValueAsString(todo);

        mockMvc.perform(MockMvcRequestBuilders.put("/todos/{id}",todo.getId())
                        .contentType(MediaType.APPLICATION_JSON).content(oldTodo))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.context").value(todo.getContext()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.done").value(todo.getDone()));
    }

//    @Test
//    public void should_return_null_when_



}
