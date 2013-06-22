package com.friends.charity.view.template.MamorTahghigh.event;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
public class PrivateMamorEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	private String changePage = "/WEB-INF/template/MamorTahghigh/menu/center/MamorProfile.xhtml";

	public String getChangePage() {
		return changePage;
	}

	public void setChangePage(String changePage) {
		this.changePage = changePage;
	}

	public void changePage() {
		String str = ((HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest())
				.getParameter("mamorChangePage");
		setChangePage(str);
	}
}
