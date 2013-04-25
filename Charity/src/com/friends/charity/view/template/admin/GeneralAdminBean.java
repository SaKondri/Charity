package com.friends.charity.view.template.admin;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.view.template.admin.menu.AdminMenuBean;

@Named
@SessionScoped
public class GeneralAdminBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private AdminMenuBean adminMenuBean;

	public AdminMenuBean getAdminMenuBean() {
		return adminMenuBean;
	}

	public void setAdminMenuBean(AdminMenuBean adminMenuBean) {
		this.adminMenuBean = adminMenuBean;
	}

}
