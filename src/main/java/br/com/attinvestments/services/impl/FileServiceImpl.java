package br.com.attinvestments.services.impl;

import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.attinvestments.domain.File;
import br.com.attinvestments.domain.Person;
import br.com.attinvestments.dto.FileNewDTO;
import br.com.attinvestments.dto.PersonNewDTO;
import br.com.attinvestments.repositories.FileRepository;
import br.com.attinvestments.repositories.PersonRepository;
import br.com.attinvestments.repositories.UserRepository;
import br.com.attinvestments.services.FileService;
import br.com.attinvestments.services.PersonService;

@Service
public class FileServiceImpl implements FileService {

	private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class.getSimpleName());
	
	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	private FileRepository fileRepo;
	
	

	@Override
	public File fromDTO(FileNewDTO objDto) {

		try {
			Person person = personRepo.findByEmailUserPerson(objDto.getPersonaId());
			
			File file = new File();
			
			if(objDto.getFile1() != null) {
				file.setFile(objDto.getFile1().getBytes());
				file.setName(objDto.getName1());
				file.setPerson(person);
				insert(file);
			}
			
			if(objDto.getFile2() != null) {
				file.setFile(objDto.getFile2().getBytes());
				file.setName(objDto.getName2());
				file.setPerson(person);
				insert(file);
			}
			
			if(objDto.getFile3() != null) {
				file.setFile(objDto.getFile3().getBytes());
				file.setName(objDto.getName3());
				file.setPerson(person);
				insert(file);
			}
			
			return file;

		} catch (Exception e) {
			logger.error("[PersonServiceImpl][fromDTO] error: ", e);
		}
		
		return null;
	}

	  @Override
	 
	 @Transactional 
	 public File insert(File obj) { 
		  obj = fileRepo.save(obj);
	 
	 return obj; 
	  }	 

}
