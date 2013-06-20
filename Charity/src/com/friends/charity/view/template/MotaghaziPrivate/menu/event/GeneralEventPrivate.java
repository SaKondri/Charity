package com.friends.charity.view.template.MotaghaziPrivate.menu.event;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
public class GeneralEventPrivate implements Serializable {
	private static final long serialVersionUID = 1L;
	private String changePage = "/WEB-INF/template/MotaghaziPrivate/menu/center/profile.xhtml";

	public String getChangePage() {
		return changePage;
	}

	public void setChangePage(String changePage) {
		this.changePage = changePage;
	}

	public void changePrivatePage(ActionEvent actionEvent) {
		String parameter = ((HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest())
				.getParameter("changePagePrivate");
		setChangePage(parameter);

	}

}
