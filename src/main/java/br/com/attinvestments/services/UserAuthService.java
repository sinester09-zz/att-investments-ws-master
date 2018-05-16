package br.com.attinvestments.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.attinvestments.security.UserSS;

public class UserAuthService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}

}
