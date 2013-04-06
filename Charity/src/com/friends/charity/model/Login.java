package com.friends.charity.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOGIN")
@NamedQueries({ 
	@NamedQuery(name ="selectUsernamePassword",query = "select u from Login as u where u.usernamePassword.username=:username and u.usernamePassword.password=:password")

})
public class Login extends BaseEntity {
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private User user;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private UsernamePassword usernamePassword;

	public User getUser() {
		if (user == null) {
			user = new User();
		}
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UsernamePassword getUsernamePassword() {
		if (usernamePassword == null) {
			usernamePassword = new UsernamePassword();
		}
		return usernamePassword;
	}

	public void setUsernamePassword(UsernamePassword usernamePassword) {
		this.usernamePassword = usernamePassword;
	}

}