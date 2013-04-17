package com.friends.charity.view.template.MotaghaziPrivate.menu.north.event;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
public class NorthEvent {

	public String btnLogOut() {
		((HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest()).getSession().invalidate();
		return "/pages/home.xhtml?faces-redirect=true";
	}
}
