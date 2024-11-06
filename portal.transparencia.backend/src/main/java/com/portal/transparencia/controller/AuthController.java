package com.portal.transparencia.controller;
import com.portal.transparencia.model.User;
import com.portal.transparencia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // Endpoint de login sin Spring Security
    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginRequest loginRequest) {
        // Validación manual de los campos
        if (loginRequest.getEmail() == null || loginRequest.getEmail().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El email es requerido");
        }
        if (loginRequest.getPassword() == null || loginRequest.getPassword().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La contraseña es requerida");
        }

        // Buscar al usuario en la base de datos
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            // Si las credenciales son correctas
            return ResponseEntity.ok("Login exitoso");
        } else {
            // Si las credenciales son incorrectas
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}
