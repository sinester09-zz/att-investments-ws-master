package br.com.attinvestments.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.attinvestments.domain.converters.LocalDateTimeConverter;

@Entity
@Table(schema="attinvest", name="user")
public class User extends BaseEntity implements Serializable {
	private static final long serialVersionUID = -3391956184751635737L;
	
	@NotEmpty
	@Column(name="username", length=20, insertable=true, nullable=false)
	private String username;
	
	@JsonIgnore
	@NotEmpty
	@Column(name="password", length=100, insertable=true, nullable=true)
	private String password;
	
	@NotEmpty
	@Column(name="email", unique=true, length=100, insertable=true, nullable=false)
	private String email;
	
	@Column(name="language_type", length=5, insertable=true, nullable=false)	
	private String languageType;
	
	@Column(name="is_validated_email", insertable=true, nullable=false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isValidatedEmail;
	
	@Column(name="is_reset_pwd", insertable=true, nullable=false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isResetPwd;
	
	@Column(name="is_policy", insertable=true, nullable=false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isPolicy;
	
	@Column(name="created", insertable=true, nullable=false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Convert(converter = LocalDateTimeConverter.class)    
	private LocalDateTime created;
	
	@Column(name="updated", insertable=true, nullable=true, columnDefinition = "DATETIME")
	@Convert(converter = LocalDateTimeConverter.class)  
	private LocalDateTime updated;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private List<Role> roles = new ArrayList<>();
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Person> persons = new ArrayList<>();
	
	public User() {}
	
	public User(Long id, @NotEmpty String username, @NotEmpty String password, @NotEmpty String email, String type,
			boolean isValidatedEmail, boolean isResetPwd, boolean isPolicy, LocalDateTime created, LocalDateTime updated) {
		super.setId(id);
		this.username = username;
		this.password = password;
		this.email = email;
		this.languageType = type;
		this.isValidatedEmail = isValidatedEmail;
		this.isResetPwd = isResetPwd;
		this.isPolicy = isPolicy;
		this.created = created;
		this.updated = updated;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLanguageType() {
		return languageType;
	}

	public void setLanguageType(String languageType) {
		this.languageType = languageType;
	}

	public boolean isValidatedEmail() {
		return isValidatedEmail;
	}

	public void setValidatedEmail(boolean isValidatedEmail) {
		this.isValidatedEmail = isValidatedEmail;
	}

	public boolean isResetPwd() {
		return isResetPwd;
	}

	public void setResetPwd(boolean isResetPwd) {
		this.isResetPwd = isResetPwd;
	}

	public boolean isPolicy() {
		return isPolicy;
	}

	public void setPolicy(boolean isPolicy) {
		this.isPolicy = isPolicy;
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

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role role) {
		if (!this.roles.contains(role)) {
			this.roles.add(role);
		}

		if (!role.getUsers().contains(this)) {
			role.getUsers().add(this);
		}
	}
	
	public void removeRole(Role role) {
		this.roles.remove(role);
		role.getUsers().remove(this);
	}
	
}
