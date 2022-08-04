package com.example.todolist.entity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kendrick Chen
 * @Date: 2022/08/04/2:48 PM
 * @Mail: KENDRICK.CHEN@OOCL.COM
 */
public class TodoRequest {
    private Integer id;
    private String context;
    private Boolean done;

    public TodoRequest(Integer id, String text, Boolean done) {
        this.id = id;
        this.context = text;
        this.done = done;
    }

    public TodoRequest() {
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

}
