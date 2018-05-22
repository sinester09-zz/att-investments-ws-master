package br.com.attinvestments.services;

import br.com.attinvestments.domain.Address;
import br.com.attinvestments.domain.Person;
import br.com.attinvestments.dto.PersonInfNewDTO;
import br.com.attinvestments.dto.PersonNewDTO;


public interface PersonInfService {
	
	Address fromDTO(PersonInfNewDTO objDto);
	
	Address insert(Address obj);
	
	


}
