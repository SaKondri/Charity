package com.friends.charity.view.template.general;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
public class GeneralEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	private String url;

	// @PostConstruct
	// public void init() {
	// getUrlPge();
	// }

	public String getUrl() throws MalformedURLException {
		getUrlPge();
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void getUrlPge() throws MalformedURLException {
		HttpServletRequest request = ((HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest());
		// String url = request.getRequestURL().toString();
		URL url = new URL(request.getRequestURL().toString());
		// URL newUrl = new URL(url.getProtocol(), url.getHost(), url.getPort(),
		// request.getContextPath());
		setUrl(url.getPath());
	}
}
