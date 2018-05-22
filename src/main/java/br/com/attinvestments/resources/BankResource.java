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

import br.com.attinvestments.domain.Bank;

import br.com.attinvestments.dto.BankNewDTO;

import br.com.attinvestments.services.BankService;



@RestController
@RequestMapping(value="/bank")
public class BankResource {
	
	private static final Logger logger = LoggerFactory.getLogger(BankResource.class.getSimpleName());
	
	@Autowired
	private BankService service;
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody BankNewDTO objDto) {
		Bank bank = service.fromDTO(objDto);
		bank = service.insert(bank);		
		return ResponseEntity.noContent().build();
	}
	
	
}
