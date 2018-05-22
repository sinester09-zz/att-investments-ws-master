package br.com.attinvestments.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.attinvestments.services.validation.UserInsert;

@UserInsert
public class PersonInfNewDTO implements Serializable {
	
	private static final long serialVersionUID = 5535446474350342396L;

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=3, max=20, message="O tamanho deve ser entre 3 e 20 caracteres")
	private String countrie;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String state;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String city;
	
	@NotEmpty(message="Idíoma o preenchimento obrigatório")
	private String postalCode;
	
	@NotEmpty(message="Idíoma o preenchimento obrigatório")
	private String addres;
	
	@NotEmpty(message="Idíoma o preenchimento obrigatório")
	private String number;
	
	@NotEmpty(message="Idíoma o preenchimento obrigatório")
	private String complement;
	
	@NotEmpty(message="Idíoma o preenchimento obrigatório")
	private String emailID;
	
	public PersonInfNewDTO() {}
	

	public String getEmailID() {
		return emailID;
	}


	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}



	public String getCountrie() {
		return countrie;
	}

	public void setCountrie(String countrie) {
		this.countrie = countrie;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	
	

	
	
}
