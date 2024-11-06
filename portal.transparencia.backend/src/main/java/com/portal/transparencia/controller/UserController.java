package com.portal.transparencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.transparencia.exceptions.ResourceNotFoundException;
import com.portal.transparencia.model.User;
import com.portal.transparencia.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserRepository repositorio;

    @GetMapping("/usuarios")
    public List<User> listAllUsers() {
        return repositorio.findAll();
    }

    @PostMapping("/usuarios")
    public User saveUser(@RequestBody User user) {
        return repositorio.save(user);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable Long id) {
        User user = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con el ID: " + id));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/usuarios/buscaremail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = repositorio.findByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con el ID: " + id));

        // Actualizar los campos del usuario
        user.setEmail(userDetails.getEmail());
        user.setRole(userDetails.getRole());
        

        User updatedUser = repositorio.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User user = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con el ID: " + id));

        repositorio.delete(user);
        return ResponseEntity.noContent().build();
    }
}

