package br.com.attinvestments.dto;


import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;



public class UserUpdateDTO implements Serializable {
	

	private static final long serialVersionUID = 1187997016094793936L;

	@NotEmpty(message="Preenchimento obrigatório")
	private int id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String name;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String email;
	@NotEmpty(message="Preenchimento obrigatório")
	private Long role;
	

	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Long getRole() {
		return role;
	}



	public void setRole(Long role) {
		this.role = role;
	}



	public UserUpdateDTO() {}


	
}
