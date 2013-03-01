package com.friends.charity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.friends.charity.model.BaseEntity;

@Entity
@Table(name = "MOARREF")
public class Moarref extends BaseEntity {
	@Column(name = "FIRST_NAME")
	private String firstname;
	@Column(name = "LAST_NAME")
	private String lastname;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
