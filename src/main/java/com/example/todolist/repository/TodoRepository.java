package com.example.todolist.repository;

import com.example.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kendrick Chen
 * @Date: 2022/08/04/1:32 PM
 * @Mail: KENDRICK.CHEN@OOCL.COM
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
