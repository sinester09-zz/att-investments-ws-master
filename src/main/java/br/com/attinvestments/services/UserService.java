package br.com.attinvestments.services;

import javax.validation.Valid;

import br.com.attinvestments.domain.User;
import br.com.attinvestments.dto.ConfirmEmailDTO;
import br.com.attinvestments.dto.UserNewDTO;
import br.com.attinvestments.dto.UserUpdateDTO;

public interface UserService {
	
	User fromDTO(UserNewDTO objDto);
	
	User insert(User obj);
	
	String validToken(ConfirmEmailDTO confirm);

	void aprove(UserUpdateDTO objDto);

}
