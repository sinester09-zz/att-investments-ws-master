package br.com.attinvestments.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema="attinvest", name="role")
public class Role extends BaseEntity implements GrantedAuthority, Serializable {
	private static final long serialVersionUID = 394824003516819661L;
	
	@Column(name="role", length=20, insertable=true, nullable=false)
	private String role;
	
	@Column(name="description", length=40, insertable=true, nullable=false)
	private String description;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "roles")
	private List<User> users = new ArrayList<>();

	public Role() {}
	
	public Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void addUser(User user) {
		if (!this.users.contains(user)) {
			this.users.add(user);
		}

		if (!user.getRoles().contains(this)) {
			user.getRoles().add(this);
		}
	}

	public void removeUser(User user) {
		this.users.remove(user);
		user.getRoles().remove(this);
	}

	@Override
	public String getAuthority() {
		return this.role;
	}	
}
