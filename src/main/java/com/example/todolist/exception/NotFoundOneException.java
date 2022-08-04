package com.example.todolist.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kendrick Chen
 * @Date: 2022/08/04/2:52 PM
 * @Mail: KENDRICK.CHEN@OOCL.COM
 */
public class NotFoundOneException extends RuntimeException {
    public NotFoundOneException(String message) {
        super(message + " not found");
    }
}

