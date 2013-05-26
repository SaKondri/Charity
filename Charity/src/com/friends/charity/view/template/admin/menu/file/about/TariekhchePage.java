package com.friends.charity.view.template.admin.menu.file.about;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.admin.about.Tariekhche;
import com.friends.charity.view.template.general.GeneralEvent;
import com.friends.charity.view.template.general.GeneralTempPage;
@Named
@RequestScoped
public class TariekhchePage implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private GeneralService dao;
	private Tariekhche tariekhche;
	
	
	public GeneralService getDao() {
		if(dao == null){
			dao = new GeneralService();
		}
		return dao;
	}
	public void setDao(GeneralService dao) {
		this.dao = dao;
	}
	public Tariekhche getTariekhche() {
		if(tariekhche == null){
			tariekhche = new Tariekhche();
		}
		return tariekhche;
	}
	
	public void setTariekhche(Tariekhche tariekhche) {
		this.tariekhche = tariekhche;
	}
	
	public String btnSave(ActionEvent actionEvent){
		try {
			getDao().save(getTariekhche());
			//FacesContext.getCurrentInstance().getExternalContext().
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			setTariekhche(null);
		}
		return null;
	}
	
	public String showTarikhche(ActionEvent actionEvent){
		List<Tariekhche> tariekhches = new ArrayList<>();	
		try {
			   tariekhches.add( (Tariekhche) getDao().select("showTarikhche", null));
			   setTariekhche(tariekhches.get(1));
				
				System.out.println("================================="+getTariekhche().getDescription());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("eeeeeerrrrrrrrrrrrrrrooooorrrr"+e.getMessage());
			}
		return null;
	}
	
}
