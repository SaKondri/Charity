package com.friends.charity.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "USERS")
@Inheritance(strategy = InheritanceType.JOINED)
@Proxy(lazy = false)
public class User extends BaseEntity {
	@Column(name = "FIRST_NAME")
	private String firstname;
	@Column(name = "LAST_NAME")
	private String lastname;
	@Column(name = "BIRTHDAY")
	@Temporal(TemporalType.DATE)
	private Calendar birthday;

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

	public Calendar getBirthday() {
		if (birthday == null) {
			birthday = Calendar.getInstance();
		}
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

}
