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
@Table(schema="attinvest", name="address")
public class Address extends BaseEntity implements Serializable {
	private static final long serialVersionUID = -4522567184656938441L;
	
	@Column(name="address", length=200, insertable=true, nullable=false)
	private String address;
	
	@Column(name="number", length=10, insertable=true, nullable=false)
	private String number;
	
	@Column(name="complement", length=50, insertable=true, nullable=true)
	private String complement;
	
	@Column(name="district", length=30, insertable=true, nullable=true)
	private String district;
	
	@Column(name="postalcode", length=10, insertable=true, nullable=false)
	private String postalCode;
	
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
	
	@ManyToOne
	@JoinColumn(name="countrie_id")
	private Countrie countrie;
	
	@ManyToOne
	@JoinColumn(name="state_id")
	private State state;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city; 
		
	public Address() {}

	public Address(Long id, String address, String number, String complement, String district, String postal_code,
			LocalDateTime created, LocalDateTime updated, Person person, Countrie countrie, State state, City city) {
		super.setId(id);
		this.address = address;
		this.number = number;
		this.complement = complement;
		this.district = district;
		this.postalCode = postal_code;
		this.created = created;
		this.updated = updated;
		this.person = person;
		this.countrie = countrie;
		this.state = state;
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postal_code) {
		this.postalCode = postal_code;
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

	public Countrie getCountrie() {
		return countrie;
	}

	public void setCountrie(Countrie countrie) {
		this.countrie = countrie;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
}
