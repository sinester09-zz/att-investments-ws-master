package br.com.attinvestments.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.attinvestments.domain.Person;
import br.com.attinvestments.dto.PersonNewDTO;
import br.com.attinvestments.repositories.PersonRepository;
import br.com.attinvestments.repositories.UserRepository;
import br.com.attinvestments.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class.getSimpleName());
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PersonRepository personRepo;

	@Override
	public Person fromDTO(PersonNewDTO objDto) {

		try {
			Person person = personRepo.findByEmail(objDto.getEmailID()).get(0);
			person.setName(objDto.getName());
			person.getUser().setLanguageType(objDto.getEmailID());
			
		/*	personRepo.save(person);
			userRepo.save(person.getUser());*/

			return person;

		} catch (Exception e) {
			logger.error("[PersonServiceImpl][fromDTO] error: ", e);
		}
		
		return null;
	}

	  @Override
	 
	 @Transactional 
	 public Person insert(Person obj) { 
		  obj = personRepo.save(obj);
	 
	 return obj; 
	  }	 

}
