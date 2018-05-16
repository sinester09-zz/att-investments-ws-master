package br.com.attinvestments.services;

import br.com.attinvestments.domain.User;
import br.com.attinvestments.dto.ConfirmEmailDTO;
import br.com.attinvestments.dto.UserNewDTO;

public interface UserService {
	
	User fromDTO(UserNewDTO objDto);
	
	User insert(User obj);
	
	String validToken(ConfirmEmailDTO confirm);

}
