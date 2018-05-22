package br.com.attinvestments.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.attinvestments.domain.Address;
import br.com.attinvestments.domain.City;
import br.com.attinvestments.domain.Countrie;
import br.com.attinvestments.domain.Person;
import br.com.attinvestments.domain.State;
import br.com.attinvestments.dto.PersonInfNewDTO;
import br.com.attinvestments.dto.PersonNewDTO;
import br.com.attinvestments.repositories.AddressRepository;
import br.com.attinvestments.repositories.CityRepository;
import br.com.attinvestments.repositories.CountrieRepository;
import br.com.attinvestments.repositories.PersonInfRepository;
import br.com.attinvestments.repositories.PersonRepository;
import br.com.attinvestments.repositories.StateRepository;
import br.com.attinvestments.repositories.UserRepository;
import br.com.attinvestments.services.PersonInfService;
import br.com.attinvestments.services.PersonService;

@Service
public class PersonInfServiceImpl implements PersonInfService {

	private static final Logger logger = LoggerFactory.getLogger(PersonInfServiceImpl.class.getSimpleName());
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CountrieRepository countrieRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	@Autowired
	private PersonInfRepository personRepo;

	@Override
	public Address fromDTO(PersonInfNewDTO objDto) {

		try {
			Person person = personRepo.findByEmail(objDto.getEmailID()).get(0);
			Countrie countrie =  countrieRepo.findById(objDto.getCountrie());
			City city = cityRepo.findById(objDto.getCity());
			State state = stateRepo.findById(objDto.getState());
			Address a = new Address();
			a.setAddress(objDto.getAddres());
			a.setCountrie(countrie);
			a.setCity(city);
			a.setState(state);
			a.setPerson(person);
			
			return a;

		} catch (Exception e) {
			logger.error("[PersonInfServiceImpl][fromDTO] error: ", e);
		}
		
		return null;
	}

	 @Override
	 
	 @Transactional 
	 public Address insert(Address obj) { 
		 obj = addressRepo.save(obj);
	 
	 return obj; 
	 }
	 

}
