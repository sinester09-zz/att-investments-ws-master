package br.com.attinvestments.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.attinvestments.domain.Address;
import br.com.attinvestments.domain.Bank;
import br.com.attinvestments.domain.City;
import br.com.attinvestments.domain.Countrie;
import br.com.attinvestments.domain.Person;
import br.com.attinvestments.domain.State;
import br.com.attinvestments.dto.BankNewDTO;
import br.com.attinvestments.dto.PersonInfNewDTO;
import br.com.attinvestments.dto.PersonNewDTO;
import br.com.attinvestments.repositories.AddressRepository;
import br.com.attinvestments.repositories.BankRepository;
import br.com.attinvestments.repositories.CityRepository;
import br.com.attinvestments.repositories.CountrieRepository;
import br.com.attinvestments.repositories.PersonInfRepository;
import br.com.attinvestments.repositories.PersonRepository;
import br.com.attinvestments.repositories.StateRepository;
import br.com.attinvestments.repositories.UserRepository;
import br.com.attinvestments.services.BankService;
import br.com.attinvestments.services.PersonInfService;
import br.com.attinvestments.services.PersonService;

@Service
public class BankServiceImpl implements BankService {

	private static final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class.getSimpleName());
	
	@Autowired
	private BankRepository bankRepo;
	

	@Autowired
	private PersonInfRepository personRepo;

	@Override
	public Bank fromDTO (BankNewDTO objDto) {

		try {
			Person person = personRepo.findByEmail(objDto.getEmailId()).get(0);
			Person personType = personRepo.findByIdTypePerson(objDto.getTypePerson());
			Bank bank = new Bank();
			bank.setBankName(objDto.getBank());
			bank.setPerson(personType);
			bank.setAgencyNumber(objDto.getAgency());
			bank.setAccountNumber(objDto.getAccountNumber());
			
			
			return bank;

		} catch (Exception e) {
			logger.error("[BankServiceImpl][fromDTO] error: ", e);
		}
		
		return null;
	}

	 @Override
	 @Transactional 
	 public Bank insert(Bank obj) { 
		 obj = bankRepo.save(obj);
	 
	 return obj; 
	 }
	 

}
