package br.com.attinvestments.services;

import br.com.attinvestments.domain.Bank;
import br.com.attinvestments.dto.BankNewDTO;



public interface BankService {
	
	Bank fromDTO(BankNewDTO objDto);
	
	Bank insert(Bank obj);
	
	


}
