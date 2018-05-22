package br.com.attinvestments.services;

import br.com.attinvestments.domain.Person;


import br.com.attinvestments.dto.PersonNewDTO;


public interface PersonService {
	
	Person fromDTO(PersonNewDTO objDto);
	
	Person insert(Person obj);
	
	


}
