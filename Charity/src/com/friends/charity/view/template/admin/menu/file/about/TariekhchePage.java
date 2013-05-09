package com.friends.charity.view.template.admin.menu.file.about;

import java.io.Serializable;

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
	@Inject
	private GeneralEvent page;
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
			try {
				setTariekhche((Tariekhche) getDao().select("showTarikhche", null));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "/";
	}
	public void goToTarikhche(ActionEvent actionEvent){
		page.setChangePage("/WEB-INF/template/general/menu/east/about/tarikhche.xhtml");
		
	}
}
