/*package com.portal.transparencia.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.portal.transparencia.services.AuthService;

public class AuthController {
	private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestParam String email, @RequestParam String password) {
        // Llamar al servicio de autenticación
        String result = authService.authenticate(email, password);

        // Retornar la respuesta
        return ResponseEntity.ok(result);
    }
}
*/