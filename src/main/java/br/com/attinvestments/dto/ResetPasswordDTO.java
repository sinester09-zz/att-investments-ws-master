package br.com.attinvestments.dto;
import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class ResetPasswordDTO implements Serializable {

	private static final long serialVersionUID = -8151491025037952496L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@NotEmpty(message="Preenchimento obrigatório")
	private String oldpassword;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String newPassword;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String newPasswordcp;
	
	
	public String getOldpassword() {
		return oldpassword;
	}


	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}


	public String getNewPassword() {
		return newPassword;
	}


	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


	public String getNewPasswordcp() {
		return newPasswordcp;
	}


	public void setNewPasswordcp(String newPasswordcp) {
		this.newPasswordcp = newPasswordcp;
	}


	
	
	public ResetPasswordDTO() {
	}


}
