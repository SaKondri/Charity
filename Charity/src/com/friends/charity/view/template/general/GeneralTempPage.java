package com.friends.charity.view.template.general;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.friends.charity.view.template.general.pic.GalleriaPage;

@Named
@SessionScoped
public class GeneralTempPage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private GalleriaPage galleriaPage;
	@Inject
	private GeneralEvent event;

	public GalleriaPage getGalleriaPage() {
		return galleriaPage;
	}

	public void setGalleriaPage(GalleriaPage galleriaPage) {
		this.galleriaPage = galleriaPage;
	}

	public GeneralEvent getEvent() {
		return event;
	}

	public void setEvent(GeneralEvent event) {
		this.event = event;
	}

}
