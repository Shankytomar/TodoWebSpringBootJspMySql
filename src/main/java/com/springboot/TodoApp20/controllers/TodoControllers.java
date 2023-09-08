package com.springboot.TodoApp20.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.TodoApp20.model.Todo;
import com.springboot.TodoApp20.repositories.TodoRepo;
import com.springboot.TodoApp20.service.TodoService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("username")
public class TodoControllers {
	@Autowired
	private TodoService TD;
	
	@Autowired
	private TodoRepo TR;

	//new todo page
	@RequestMapping(value="new-todo",method=RequestMethod.GET)
	public String newTodo(ModelMap m,@RequestParam String username,HttpSession session) {
		if(session.getAttribute("session")==null)
			{
				return "redirect:login";
			}
		Todo todo = new Todo();
		todo.setUser(username);
		m.addAttribute("username",username);
		m.addAttribute("todo",todo);
		return "newTodoPage";
		
	}
	
	// new to page proccess
	@RequestMapping(value="new-todo",method=RequestMethod.POST)
	public String addingTodo(ModelMap m,@Valid Todo todo,BindingResult result,HttpSession session) {
		if(session.getAttribute("session")==null)
		{
			return "redirect:login";
		}
		
			if(result.hasErrors()!=true) {
				System.out.println("date"+todo.getTargetDate());
				TD.addTodo(todo);
				return "redirect:manage-todo";
		}
			else {
				return"newTodoPage";
			}
		
	}
	
	//delete
	@RequestMapping(value="delete-todo",method=RequestMethod.GET)
	public String deleteTodo(ModelMap m,@RequestParam int id,HttpSession session) {
		if(session.getAttribute("session")==null)
		{
			return "redirect:login";
		}
	
		TD.deleteTodo(id);
		return "redirect:manage-todo";
	}
	
	//update page
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String updateTodo(ModelMap m, @RequestParam int id,HttpSession session) {
		if(session.getAttribute("session")==null)
		{
			return "redirect:login";
		}
		
		Todo todo = TR.getById(id);
		m.addAttribute("todo", todo);
		TD.deleteTodo(id);
		return "updateTodoPage";
	}
	
	//update process
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String updatingTodo(ModelMap m, Todo todo,HttpSession session) {
		if(session.getAttribute("session")==null)
		{
			return "redirect:login";
		}
		todo.setUser(m.getAttribute("username").toString());
		TD.addTodo(todo);
		return "redirect:manage-todo";
	}
	
	
	
	
	
}
