package br.com.attinvestments.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.attinvestments.domain.converters.LocalDateTimeConverter;

@Entity
@Table(schema="attinvest", name="state")
public class State extends BaseEntity implements Serializable {	
	private static final long serialVersionUID = -4983997527108076090L;

	@Column(name="code", length=5, insertable=true, nullable=false)
	private String code;
	
	@Column(name="name", length=100, insertable=true, nullable=false)
	private String name;
	
	@Column(name="created", insertable=true, nullable=false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Convert(converter = LocalDateTimeConverter.class)    
	private LocalDateTime created;
	
	@Column(name="updated", insertable=false, nullable=true, columnDefinition = "DATETIME")
	@Convert(converter = LocalDateTimeConverter.class)  
	private LocalDateTime updated;
	
	@ManyToOne
	@JoinColumn(name="countrie_id")
	private Countrie countrie;
	
	@JsonIgnore
	@OneToMany(mappedBy="state")
	private List<City> cities = new ArrayList<>();
	
	public State() {}

	public State(Long id, String code, String name, Countrie countrie) {
		super.setId(id);
		this.code = code;
		this.name = name;
		this.countrie = countrie;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Countrie getCountrie() {
		return countrie;
	}

	public void setCountrie(Countrie countrie) {
		this.countrie = countrie;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
}
