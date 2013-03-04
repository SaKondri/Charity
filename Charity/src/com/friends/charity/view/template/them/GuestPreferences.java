package com.friends.charity.view.template.them;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.sun.xml.xsom.impl.scd.Iterators.Map;

@Named
@SessionScoped
public class GuestPreferences implements Serializable {
	private static final long serialVersionUID = 1L;
	private String theme = "aristo-rtl"; // default

	@SuppressWarnings("unchecked")
	public String getTheme() {
		Map<String, String> params = (Map<String, String>) FacesContext
				.getCurrentInstance().getExternalContext()
				.getRequestParameterMap();
		if (((java.util.Map<String, String>) params).containsKey("theme")) {
			theme = ((java.util.Map<String, String>) params).get("theme");
		}

		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
}