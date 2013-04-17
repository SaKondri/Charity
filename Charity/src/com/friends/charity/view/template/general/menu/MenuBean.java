package com.friends.charity.view.template.general.menu;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.view.template.general.menu.file.login.LoginPage;
import com.friends.charity.view.template.general.menu.file.register.MadadJoPage;

@Named
@SessionScoped
public class MenuBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private MadadJoPage madadJoPage;
	@Inject
	private LoginPage loginPage;

	public MadadJoPage getMadadJoPage() {
		return madadJoPage;
	}

	public void setMadadJoPage(MadadJoPage madadJoPage) {
		this.madadJoPage = madadJoPage;
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(LoginPage loginPage) {
		this.loginPage = loginPage;
	}

}
