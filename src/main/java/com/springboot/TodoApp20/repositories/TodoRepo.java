package com.springboot.TodoApp20.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.TodoApp20.model.Todo;

public interface TodoRepo extends JpaRepository<Todo,Integer> {

	List <Todo> findByUser(String user);

}
