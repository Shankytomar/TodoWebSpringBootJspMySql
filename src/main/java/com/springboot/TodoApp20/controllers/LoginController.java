package com.springboot.TodoApp20.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.TodoApp20.model.Todo;
import com.springboot.TodoApp20.model.User;
import com.springboot.TodoApp20.repositories.UserRepo;
import com.springboot.TodoApp20.service.AuthenticationService;
import com.springboot.TodoApp20.service.TodoService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("username")
public class LoginController {
	@Autowired
	private AuthenticationService AS;
	@Autowired
	private TodoService TS;
	@Autowired
	private UserRepo UR;

	//login request
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(ModelMap m){
		User user = new User();
		m.addAttribute("user",user);
		return "loginPage";
	}
	
	//login data validation
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String loginProcess(ModelMap m,@Valid User user,BindingResult result, HttpSession session) {
			//validation check user
			//user.username and user.password has min 4 char
		   
		    //for for user authentication
			     if(AS.validUser(user.getUsername(),user.getPassword())==true) {
			         	//2 session object created
			    	 
				      String s = user.getUsername();
				      session.setAttribute("session", s);
				      System.out.println("session generated "+session.getAttribute("session"));
				      m.addAttribute("username", user.getUsername());
				      System.out.println(m.getAttribute("username"));
				      return "welcomePage";
			       }
			     else {
			    	 return "loginPage";
			     }
		    
	}
	
		// load user's todo data
		@RequestMapping(value="manage-todo",method=RequestMethod.GET)
		public String welcome(ModelMap m,HttpSession session){
			if(session.getAttribute("session")==null)
			{
				System.out.println(session.getAttribute("session"));
				return "redirect:login";
			}
			//3 load user's all todo
			System.out.println("session= "+session.getAttribute("session"));
			System.out.println(m.getAttribute("username"));
			List<Todo> todos =TS.loadUserTodos((String) m.getAttribute("username"));
			m.addAttribute("todos",todos);
			return "todoPage";
			
	}

		@RequestMapping(value="/new-user",method=RequestMethod.GET)
		public String addUser(ModelMap m,HttpSession session) {
		    User user = new User();
		    m.clear();
		    m.addAttribute("user", user);
			return "newUserPage";
		}

		@RequestMapping(value="/new-user",method=RequestMethod.POST)
		public String addingUser(ModelMap m,User user) {
		    UR.save(user);
			return "loginPage";
		}
	
		@RequestMapping(value="/logout",method=RequestMethod.GET)
		public String logout(ModelMap m, HttpSession session) {
		    m.clear();
		    //session out
		    session.invalidate();
		    //System.out.println("session generated "+session.getAttribute("session"));
			return "redirect:login";
		}
	
}
