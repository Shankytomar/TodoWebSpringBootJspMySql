package com.springboot.TodoApp20.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.TodoApp20.model.User;
import com.springboot.TodoApp20.repositories.UserRepo;

@Service
public class AuthenticationService {
	
	@Autowired
	private UserRepo repo;

	//return user object or null
	public User getUserByName(String username) {
     		User u = repo.findByUsername(username);
     		System.out.print(u);
     		return u;	
	}
	
	public boolean validUser(String username,String password) {
			User u =getUserByName(username);
			if(u!=null && u.getPassword().equals(password)) {
				return true;
			    }
			else
				return false;	
		}
}
