package br.com.attinvestments.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.attinvestments.domain.User;
import br.com.attinvestments.repositories.UserRepository;
import br.com.attinvestments.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	@Autowired
	private UserRepository userRepo;	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(email);
		if (user == null || (user.isValidatedEmail() == false)) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getLanguageType(), user.getRoles());
	}
	
}
