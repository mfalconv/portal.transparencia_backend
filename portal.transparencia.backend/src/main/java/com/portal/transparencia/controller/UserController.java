package com.portal.transparencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.transparencia.exceptions.ResourceNotFoundException;
import com.portal.transparencia.model.User;
import com.portal.transparencia.repository.UserRepository;

@RestController
@RequestMapping ("/api/v1/")
// @CrossOrigin(origins= "") -> añadir aqui la ruta del front para intercambiar servicios
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
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<User> getUserByID(@PathVariable Long id){
		User user= repositorio.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("No existe el empleado con el ID: "+ id));
		return ResponseEntity.ok(user);
		
	}
}
