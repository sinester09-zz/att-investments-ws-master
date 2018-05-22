package br.com.attinvestments.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;


@Entity
@Table(schema="attinvest", name="file")
public class File extends BaseEntity implements Serializable {
	private static final long serialVersionUID = -3648324053798089746L;
	
	
	@Id
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;
	
	@Column(name="name", insertable=true)
	private String name;
	
	@Lob
	@Column(name="file", insertable=true)
	private byte[] file;
	
	
	
	public File(Person person, String name, byte[] file) {
		super();
		this.person = person;
		this.name = name;
		this.file = file;
	}


	public File() {}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public byte[] getFile() {
		return file;
	}


	public void setFile(byte[] file) {
		this.file = file;
	} 

	

	
	
}
