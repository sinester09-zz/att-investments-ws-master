package br.com.attinvestments.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.attinvestments.domain.converters.LocalDateTimeConverter;

@Entity
@Table(schema="attinvest", name="bank")
public class Bank extends BaseEntity implements Serializable {
	private static final long serialVersionUID = -392602851890900960L;
	
	@Column(name="bank_number", length=10, insertable=false, nullable=true)
	private String bankNumber;
	
	@Column(name="bank_name", length=100, insertable=true, nullable=true)
	private String bankName;
	
	@Column(name="agency_number", length=20, insertable=true, nullable=false)
	private String agencyNumber;
	
	@Column(name="account_number", length=20, insertable=true, nullable=false)
	private String accountNumber;
	
	@Column(name="created", insertable=true, nullable=false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Convert(converter = LocalDateTimeConverter.class)    
	private LocalDateTime created;
	
	@Column(name="updated", insertable=false, nullable=true, columnDefinition = "DATETIME")
	@Convert(converter = LocalDateTimeConverter.class)  
	private LocalDateTime updated;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;

	public Bank() {}

	public Bank(Long id, String bank_number, String bank_name, String agency_number, String account_number,
			Person person) {
		super.setId(id);
		this.bankNumber = bank_number;
		this.bankName = bank_name;
		this.agencyNumber = agency_number;
		this.accountNumber = account_number;
		this.person = person;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bank_number) {
		this.bankNumber = bank_number;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bank_name) {
		this.bankName = bank_name;
	}

	public String getAgencyNumber() {
		return agencyNumber;
	}

	public void setAgencyNumber(String agency_number) {
		this.agencyNumber = agency_number;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String account_number) {
		this.accountNumber = account_number;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
