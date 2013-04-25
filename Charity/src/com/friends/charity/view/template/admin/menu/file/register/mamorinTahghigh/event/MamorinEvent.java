package com.friends.charity.view.template.admin.menu.file.register.mamorinTahghigh.event;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import com.friends.charity.business.logic.CalendarFormat;
import com.friends.charity.business.service.GeneralService;
import com.friends.charity.business.service.model.LoginService;
import com.friends.charity.model.Login;
import com.friends.charity.model.MamorinTahghigh;

@Named
public class MamorinEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	private MamorinTahghigh mamorinTahghigh;
	private Login login;
	private GeneralService generalService;
	private LoginService loginService;
	private String username;

	public MamorinTahghigh getMamorinTahghigh() {
		if (mamorinTahghigh == null) {
			mamorinTahghigh = new MamorinTahghigh();
		}
		return mamorinTahghigh;
	}

	public void setMamorinTahghigh(MamorinTahghigh mamorinTahghigh) {
		this.mamorinTahghigh = mamorinTahghigh;
	}

	public Login getLogin() {
		if (login == null) {
			login = new Login();
		}
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public GeneralService getGeneralService() {
		if (generalService == null) {
			generalService = new GeneralService();
		}
		return generalService;
	}

	public void setGeneralService(GeneralService generalService) {
		this.generalService = generalService;
	}

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
		Login login = null;
		try {
			login = getLoginService().getCorrectUsername(username);
			if (login != null) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا",
								"...نام کاربری موجود میباشد"));
				setUsername(null);
			} else {
				getLogin().getUsernamePassword().setUsername(getUsername());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void btnSaved(ActionEvent actionEvent) {
		FacesMessage message = new FacesMessage();
		FacesContext context = FacesContext.getCurrentInstance();
		getMamorinTahghigh().setBirthday(
				CalendarFormat.getGerigorian(getMamorinTahghigh().getDate()));
		getLogin().setUser(getMamorinTahghigh());
		try {
			getGeneralService().save(getLogin());
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setDetail("ذخیره");
			message.setSummary(".اطلاعات شما با موفقیت ذخیره شد");
			context.addMessage(null, message);
		} catch (Exception e) {
			message.setSeverity(FacesMessage.SEVERITY_FATAL);
			message.setDetail("خطا");
			message.setSummary(".مجددا امتحان فرمائید");
			nullEntity();
			context.addMessage(null, message);
			e.printStackTrace();
		}

	}

	private void nullEntity() {
		setLogin(null);
		setMamorinTahghigh(null);
		setUsername(null);
	}
}
