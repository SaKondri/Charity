package com.friends.charity.view.template.general.menu.file.login.event;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.friends.charity.business.service.model.LoginService;
import com.friends.charity.model.Login;
import com.friends.charity.model.MoshakhasateMotaghazi;

@Named
public class LoginEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	private LoginService loginService;
	private String username;
	private String password;

	public LoginService getLoginService() {
		if (loginService == null) {
			loginService = new LoginService();
		}
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
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

	public String btnSubmit() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		Login login = null;
		try {
			login = getLoginService()
					.getLoginTest(getUsername(), getPassword());
			if (login != null) {
				if (login.getUser() instanceof MoshakhasateMotaghazi) {
					nullFields();
					((HttpServletRequest) FacesContext.getCurrentInstance()
							.getExternalContext().getRequest()).getSession()
							.setAttribute("login", login);
					return "/pages/private/login.xhtml?faces-redirect=true";
				}
			} else if (login == null) {
				nullFields();
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setDetail("خطا");
				message.setSummary("چنین کاربری موجود نمی باشد.");
				context.addMessage(null, message);
			}
		} catch (Exception e) {
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setDetail("خطا");
			message.setSummary("خطای سیستمی.");
			context.addMessage(null, message);
			e.printStackTrace();
		}
		return null;

	}

	public void nullFields() {
		setUsername(null);
		setPassword(null);
	}

}