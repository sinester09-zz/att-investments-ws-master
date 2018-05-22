package br.com.attinvestments.services;

import br.com.attinvestments.domain.File;
import br.com.attinvestments.dto.BankNewDTO;
import br.com.attinvestments.dto.FileNewDTO;



public interface FileService {
	
	File fromDTO(FileNewDTO objDto);
	
	File insert(File obj);
	
	


}
