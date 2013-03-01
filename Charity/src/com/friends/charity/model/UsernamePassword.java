package com.friends.charity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USERNAME_PASSWORD")
public class UsernamePassword extends BaseEntity {
	@Column(name = "USERNAME", unique = true)
	private String username;
	@Column(name = "PASSWORD")
	private String password;

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

}
