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
import br.com.attinvestments.domain.enums.Phone_type;

@Entity
@Table(schema="attinvest", name="phone")
public class Phone extends BaseEntity implements Serializable {
	private static final long serialVersionUID = -3003257741797449268L;
	
	@Column(name="phone_number", length=20, insertable=true, nullable=false)
	private String phoneNumber;

	@Column(name="phone_type", insertable=true, nullable=false)
	private Integer phoneType;
	
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
	
	public Phone() {}

	public Phone(Long id, String phoneNumber, Phone_type phoneType, LocalDateTime created, LocalDateTime updated, Person person) {
		super.setId(id);
		this.phoneNumber = phoneNumber;
		this.phoneType = (phoneType==null ? null : phoneType.getCod());
		this.created = created;
		this.updated = updated;
		this.person = person;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Phone_type getPhoneType() {
		return Phone_type.toEnum(this.phoneType);
	}

	public void setPhoneType(Phone_type phoneType) {
		this.phoneType = phoneType.getCod();
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
