package com.springboot.TodoApp20.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.TodoApp20.model.Todo;
import com.springboot.TodoApp20.repositories.TodoRepo;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepo TR;

	public List<Todo> loadUserTodos(String username){
		List <Todo> todos = TR.findByUser(username);
		return todos;
	}
	
	public void addTodo(Todo t) {
		TR.save(t);
	}
	
	public void deleteTodo(int todoId) {
		TR.deleteById(todoId);
	}
}
