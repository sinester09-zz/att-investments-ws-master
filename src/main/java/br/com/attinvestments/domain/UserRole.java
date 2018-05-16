package br.com.attinvestments.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import br.com.attinvestments.domain.converters.LocalDateTimeConverter;

@Entity
@Table(schema="attinvest", name="user_role")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 8932601124534162652L;
	
	@EmbeddedId
    private UserRoleId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roleId")
    private Role role;
	
	@Column(name="created", insertable=true, nullable=false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Convert(converter = LocalDateTimeConverter.class)    
	private LocalDateTime created;
	
	public UserRole() {}

	public UserRole(User user, Role role) {
		this.user = user;
		this.role = role;
		this.id = new UserRoleId(user.getId(), role.getId());
	}

	public UserRoleId getId() {
		return id;
	}

	public void setId(UserRoleId id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
