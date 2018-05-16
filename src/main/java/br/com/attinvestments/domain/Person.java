package br.com.attinvestments.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.attinvestments.domain.converters.LocalDateTimeConverter;
import br.com.attinvestments.domain.enums.Person_type;

@Entity
@Table(schema="attinvest", name="person")
public class Person extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1906651786912196251L;
	
	@Column(name="name", length=200, insertable=true, nullable=false)
	private String name;
	
	@Column(name="document", unique=true, length=20, insertable=true, nullable=false)
	private String document;
	
	@Column(name="person_type", insertable=true, nullable=false)
	private char personType;
	
	@Column(name="created", insertable=true, nullable=false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Convert(converter = LocalDateTimeConverter.class)    
	private LocalDateTime created;
	
	@Column(name="updated", insertable=false, nullable=true, columnDefinition = "DATETIME")
	@Convert(converter = LocalDateTimeConverter.class)  
	private LocalDateTime updated;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="person", cascade=CascadeType.ALL)
	private List<Bank> bank = new ArrayList<>();
	
	@OneToMany(mappedBy="person", cascade=CascadeType.ALL)
	private List<Address> address = new ArrayList<>();
	
	@OneToMany(mappedBy="person", cascade=CascadeType.ALL)
	private List<Phone> phones = new ArrayList<>();

	public Person() {}

	public Person(Long id, String name, String document, Person_type personType, User user) {
		super.setId(id);
		this.name = name;
		this.document = document;
		this.personType = personType.getCod();
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
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

	public char getPersonType() {
		return personType;
	}

	public void setPersonType(Person_type personType) {
		this.personType = personType.getCod();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Bank> getBank() {
		return bank;
	}

	public void setBank(List<Bank> bank) {
		this.bank = bank;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
}
