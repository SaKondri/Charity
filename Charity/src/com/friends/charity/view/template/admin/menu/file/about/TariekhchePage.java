package com.friends.charity.view.template.admin.menu.file.about;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.admin.about.Tariekhche;
import com.friends.charity.view.template.general.GeneralEvent;
import com.friends.charity.view.template.general.GeneralTempPage;
import com.friends.charity.view.template.general.menu.right.about.TariekhcheShow;
@Named
@RequestScoped
public class TariekhchePage implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private GeneralService dao;
	private Tariekhche tariekhche;
	@Inject
	private TariekhcheShow show;
	
	public TariekhcheShow getShow() {
		return show;
	}
	public void setShow(TariekhcheShow show) {
		this.show = show;
	}
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
			
			getTariekhche().setId(getShow().getTariekhche().getId());
			if(getShow().getTariekhche().getId() >0){
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"ویرایش","تاریخچه سایت با موفقیت ویرایش شد"));
				getDao().saveOrUpdate(getTariekhche());
			}else {
				getDao().saveOrUpdate(getTariekhche());
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"ذخیره","تاریخچه سایت با موفقیت ذخیره شد"));
			}
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"خطا","تاریخچه سایت با موفقیت ذخیره نشد"));
		}finally{
			setTariekhche(null);
		}
		return null;
	}
	public String btnEditHistore(ActionEvent actionEvent){
		
		setTariekhche(getShow().getTariekhche());
		return null;
	}
	public String showTarikhche(ActionEvent actionEvent){
		List<Tariekhche> tariekhches = new ArrayList<>();	
		try {
			   tariekhches.add( (Tariekhche) getDao().select("showTarikhche", null));
			   setTariekhche(tariekhches.get(1));
				
				System.out.println("================================="+getTariekhche().getDescription());
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"خطا",e.getMessage()));
			}
		return null;
	}
	
}
