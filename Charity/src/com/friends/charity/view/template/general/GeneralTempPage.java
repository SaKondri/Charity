package com.friends.charity.view.template.general;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.view.template.general.pic.GalleriaPage;

@Named
@ViewScoped
public class GeneralTempPage implements Serializable {
	private static final long serialVersionUID = 1L;
	private String changePage = "/WEB-INF/template/general/pic/galleria.xhtml";
	@Inject
	private GalleriaPage galleriaPage;

	public String getChangePage() {
		return changePage;
	}

	public void setChangePage(String changePage) {
		this.changePage = changePage;
	}

	public GalleriaPage getGalleriaPage() {
		return galleriaPage;
	}

	public void setGalleriaPage(GalleriaPage galleriaPage) {
		this.galleriaPage = galleriaPage;
	}

	public void changeCenterPage(ActionEvent actionEvent) {
		String page = (String) FacesContext.getCurrentInstance()
				.getExternalContext().getRequestMap().get("madadjo");
		setChangePage(page);
	}

}
