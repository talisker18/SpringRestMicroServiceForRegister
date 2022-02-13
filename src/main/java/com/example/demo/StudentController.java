package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
	
	@Autowired
	StudentRepo repo;
	
	@ResponseBody
	@RequestMapping("/register-user/{user}/{password}/{email}")
	public String checkregister(@PathVariable("user") String user, @PathVariable("password") String password, @PathVariable("email") String email, HttpServletRequest req, HttpServletResponse resp) {
		Student s = new Student();
		s.setName(user);
		s.setPassword(password);
		s.setEmail(email);
		
		repo.save(s);
		
		return "successfull register";
	}
}
