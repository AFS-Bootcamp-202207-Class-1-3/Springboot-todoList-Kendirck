package com.example.todolist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * @Author: Kendrick Chen
 * @Date: 2022/08/04/11:57 AM
 * @Mail: KENDRICK.CHEN@OOCL.COM
 */

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String context;
    private Boolean done;

    public Todo(Integer id, String text, Boolean done) {
        this.id = id;
        this.context = text;
        this.done = done;
    }

    public Todo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public void merge(Todo todo){
        this.context=todo.context;
        this.done=todo.done;
    }
}
