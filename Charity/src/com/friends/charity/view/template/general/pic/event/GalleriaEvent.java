package com.friends.charity.view.template.general.pic.event;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
public class GalleriaEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	private String description;


	public void picDicription(String disc) {
		switch (disc) {
		case "charity1.jpg":
			setDescription("World help");
			break;
		case "charity2.jpg":
			setDescription("Give");
			break;
		case "charity3.jpg":
			setDescription("Please Give");
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
