package br.com.attinvestments.resources;


import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.attinvestments.domain.Address;
import br.com.attinvestments.domain.Person;
import br.com.attinvestments.domain.User;
import br.com.attinvestments.dto.ConfirmEmailDTO;
import br.com.attinvestments.dto.PersonInfNewDTO;
import br.com.attinvestments.dto.PersonNewDTO;
import br.com.attinvestments.dto.UserNewDTO;
import br.com.attinvestments.services.PersonInfService;
import br.com.attinvestments.services.PersonService;
import br.com.attinvestments.services.UserService;


@RestController
@RequestMapping(value="/compl")
public class PersonInfResource {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonInfResource.class.getSimpleName());
	
	@Autowired
	private PersonInfService service;
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PersonInfNewDTO objDto) {
		Address address = service.fromDTO(objDto);
		address = service.insert(address);		
		return ResponseEntity.noContent().build();
	}
	
	
}
