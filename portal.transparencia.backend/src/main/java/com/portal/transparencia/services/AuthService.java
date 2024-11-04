/*package com.portal.transparencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	private final AuthenticationManager authenticationManager;

	public AuthService(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public String authenticate(String username, String password) {
		// Autenticar usando AuthenticationManager
		org.springframework.security.core.Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		// Establecer la autenticación en el contexto de seguridad
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Retornar mensaje de éxito o token (por ahora solo mensaje de éxito)
		return "Login successful";
	}

}
*/