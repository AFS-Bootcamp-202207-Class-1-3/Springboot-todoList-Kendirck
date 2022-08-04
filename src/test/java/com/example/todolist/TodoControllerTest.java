package com.example.todolist;

import com.example.todolist.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void should_return_todos_when_get_all_todos() throws Exception{
        Todo todo = new Todo(1,"first to do item",true);
        mockMvc.perform(MockMvcRequestBuilders.get("/todos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(todo.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].text").value(todo.getText()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].done").value(todo.getDone()));
    }

}
