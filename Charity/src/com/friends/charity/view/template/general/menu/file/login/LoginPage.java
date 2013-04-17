package com.friends.charity.view.template.general.menu.file.login;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.view.template.general.menu.file.login.event.LoginEvent;

@Named
@SessionScoped
public class LoginPage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private LoginEvent event;

	public LoginEvent getEvent() {
		return event;
	}

	public void setEvent(LoginEvent event) {
		this.event = event;
	}

	public String btnSubmit() {
		return getEvent().btnSubmit();
	}
}
