package br.com.attinvestments.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.attinvestments.domain.Role;

public class UserSS implements UserDetails {
	private static final long serialVersionUID = 728492969600866178L;
	
	private Long id;
	private String username;
	private String email;
	private String password;
	private String lang;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserSS() {
	}
	
	public UserSS(Long id, String username, String email, String password, String lang, List<Role> roles) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.lang = lang;
		this.authorities = roles.stream().map(x -> new SimpleGrantedAuthority(x.getRole())).collect(Collectors.toList());
	}
	
	public Long getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	public String getEmail() {
		return email;
	}

	public String getLang() {
		return lang;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public boolean hasRole(Role role) {
		return getAuthorities().contains(new SimpleGrantedAuthority(role.getRole()));
	}

}
