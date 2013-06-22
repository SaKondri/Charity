package com.friends.charity.view.template.MamorTahghigh.menu.north.event;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
public class NorthmamorEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	public String btnLogout() {
		((HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest()).getSession().invalidate();
		return "/pages/home.xhtml?faces-redirect=true";
	}
}
