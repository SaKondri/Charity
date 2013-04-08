package com.friends.charity.view.template.admin.login;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import com.friends.charity.view.template.general.GeneralTempPage;
@Named
@RequestScoped
public class AdminLoginPage implements Serializable{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private boolean isAdmin = false;
	@Inject
	private GeneralTempPage generalTempPage;
	public boolean isAdmin() {
		return isAdmin;
	}
	public GeneralTempPage getGeneralTempPage() {
		return generalTempPage;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
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
	
	public String btnLogin(){
		if(getUsername().equals("admin") && getPassword().equals("admin")){
			getGeneralTempPage().getEvent().setAdminChangePage("/WEB-INF/template/admin/protect/adminHome.xhtml");
			//return "/WEB-INF/template/admin/adminPage.xhtml";
		}
		FacesContext.getCurrentInstance().addMessage("frmAdminLogin", new FacesMessage(FacesMessage.SEVERITY_WARN, "شناسه و کلمه عبور صحیح نمی باشد", ""));
		return null;
	}
}
