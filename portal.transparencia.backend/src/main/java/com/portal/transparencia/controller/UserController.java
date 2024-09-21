package com.portal.transparencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.transparencia.model.User;
import com.portal.transparencia.repository.UserRepository;

@RestController
@RequestMapping ("/api/v1/")
public class UserController {
	
	
	@Autowired
	private UserRepository repositorio;
	
	@GetMapping("/usuarios")
	public List<User> listallUsers(){
		return repositorio.findAll();
		}
	
	@PostMapping("/usuarios")
	public User saveUser(@RequestBody User user) {
		return repositorio.save(user);
		
	}
	
}
