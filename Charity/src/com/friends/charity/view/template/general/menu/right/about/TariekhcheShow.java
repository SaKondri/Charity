package com.friends.charity.view.template.general.menu.right.about;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.admin.about.Tariekhche;

@Named

public class TariekhcheShow implements Serializable {

	private static final long serialVersionUID = 1L;
	private Tariekhche tariekhche;
	private GeneralService dao;
	private String adminChangePageHome;

	public String getAdminChangePageHome() {
		return adminChangePageHome;
	}

	public void setAdminChangePageHome(String adminChangePageHome) {
		this.adminChangePageHome = adminChangePageHome;
	}

	public GeneralService getDao() {
		if (dao == null) {
			dao = new GeneralService();
		}
		return dao;
	}

	public void setDao(GeneralService dao) {
		this.dao = dao;
	}

	public Tariekhche getTariekhche() {
		if (tariekhche == null) {
			tariekhche = new Tariekhche();
			
		}
		return tariekhche;
	}

	public void setTariekhche(Tariekhche tariekhche) {
		this.tariekhche = tariekhche;
	}
	
	public void changeCenterPageAdminHome(ActionEvent actionEvent) {
		String page = ((HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest()).getParameter("page");
		// gotoTarikhche(actionEvent);
		setAdminChangePageHome(page);
	}
	
	public String showTarikhche() {

		List<Tariekhche> tariekhches = new ArrayList<>();
		try {
			tariekhches =getDao().selectList("showTarikhche", null);
		setTariekhche(tariekhches.get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("eeeeeerrrrrrrrrrrrrrrooooorrrr"
					+ e.getMessage());
		}
		return null;
	}

}
