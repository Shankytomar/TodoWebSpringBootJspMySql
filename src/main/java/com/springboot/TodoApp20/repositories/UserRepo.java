package com.springboot.TodoApp20.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.TodoApp20.model.User;

public interface UserRepo extends JpaRepository<User,Integer> {
	
	User findByUsername(String username);
}
