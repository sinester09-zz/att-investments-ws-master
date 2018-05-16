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

import br.com.attinvestments.domain.User;
import br.com.attinvestments.dto.ConfirmEmailDTO;
import br.com.attinvestments.dto.UserNewDTO;
import br.com.attinvestments.services.UserService;


@RestController
@RequestMapping(value="/user")
public class UserResource {
	
	private static final Logger logger = LoggerFactory.getLogger(UserResource.class.getSimpleName());
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/newuser", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UserNewDTO objDto) {
		User user = service.fromDTO(objDto);
		user = service.insert(user);		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/confirm", method = RequestMethod.POST)
	public ResponseEntity<Void> confirmEmail(@Valid @RequestBody ConfirmEmailDTO confirm) {
		URI uri = null;
		try {
			uri = new URI(service.validToken(confirm));
		} catch (URISyntaxException e) {
			logger.error("[UserResource][confirmEmail] error: ", e);
		}
		return ResponseEntity.created(uri).build();
	}
	
}
