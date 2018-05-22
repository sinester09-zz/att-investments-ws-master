package br.com.attinvestments.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import br.com.attinvestments.services.validation.UserInsert;

@UserInsert
public class FileNewDTO implements Serializable {
	
	private static final long serialVersionUID = 5535446474350342396L;


	private String name1;
	private String name2;
	private String name3;
	
	
	private MultipartFile file1;
	
	private MultipartFile file2;
	
	private MultipartFile file3;
	
		
	private String personaId;
	
		
	public FileNewDTO() {}


	public String getName1() {
		return name1;
	}


	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}


	public void setName2(String name2) {
		this.name2 = name2;
	}


	public String getName3() {
		return name3;
	}


	public void setName3(String name3) {
		this.name3 = name3;
	}


	public MultipartFile getFile1() {
		return file1;
	}


	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}


	public String getPersonaId() {
		return personaId;
	}


	public void setPersonaId(String personaId) {
		this.personaId = personaId;
	}


	public MultipartFile getFile2() {
		return file2;
	}


	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}


	public MultipartFile getFile3() {
		return file3;
	}


	public void setFile3(MultipartFile file3) {
		this.file3 = file3;
	}
	
	

	
}
