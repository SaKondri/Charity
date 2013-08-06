package com.friends.charity.view.template.admin.menu.barresi.dialog;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.MoshakhasateMotaghazi;
import com.friends.charity.model.UserImage;
import com.friends.charity.model.farzand.Farzandan;

//@ManagedBean(name = "barresiDialogPage")
@Named
@SessionScoped
public class BarresiDialogPage implements Serializable {
	private static final long serialVersionUID = 1L;
	private MoshakhasateMotaghazi motaghazil;
	private GeneralService service;
	private List<Farzandan> farzandans;

	public void btn(ActionEvent actionEvent) {
		String str;
		str = (String) ((HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest()).getParameter("id");
		if (str != null) {
			long id = Long.parseLong(str);
			Map<String, Object> params = new HashMap<>();
			params.put("id", id);
			List<Farzandan> list = getService().selectList("selectFarzandan",
					params);
			farzandans = new ArrayList<>();
			farzandans = list;
		}
	}

	public List<Farzandan> getFarzandans() {

		return farzandans;
	}

	public void setFarzandans(List<Farzandan> farzandans) {
		this.farzandans = farzandans;
	}

	public void setService(GeneralService service) {
		this.service = service;
	}

	// public MoshakhasateMotaghazi getMotaghazil() {
	//
	// return motaghazil;
	// }

	public void setMotaghazil(MoshakhasateMotaghazi motaghazil) {
		this.motaghazil = motaghazil;
		Map<String, Object> params = new HashMap<>();
		params.put("id", motaghazil.getId());
		List<Farzandan> list = getService().selectList("selectFarzandan",
				params);
		for (Farzandan farzandan : list) {
			getFarzandans().add(farzandan);
		}
	}

	public GeneralService getService() {
		if (service == null) {
			service = new GeneralService();
		}
		return service;
	}
}