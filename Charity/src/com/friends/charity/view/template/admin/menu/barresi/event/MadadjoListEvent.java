package com.friends.charity.view.template.admin.menu.barresi.event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.hibernate.event.internal.OnReplicateVisitor;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.MoshakhasateMotaghazi;

@Named
public class MadadjoListEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	private LazyDataModel<MoshakhasateMotaghazi> lazyMadadjoDataModel;
	private MoshakhasateMotaghazi motaghazil;

	@PostConstruct
	public void init() {
		List<MoshakhasateMotaghazi> list = new ArrayList<>();
		lazyMadadjoDataModel = new LazyMadadjoDataModel(list);
	}

	public LazyDataModel<MoshakhasateMotaghazi> getLazyMadadjoDataModel() {
		return lazyMadadjoDataModel;
	}

	public MoshakhasateMotaghazi getMotaghazil() {
//		if (motaghazil == null) {
//			motaghazil = new MoshakhasateMotaghazi();
//		}
		return motaghazil;
	}

	public void setMotaghazil(MoshakhasateMotaghazi motaghazil) {
		this.motaghazil = motaghazil;

	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Car Unselected",
				((MoshakhasateMotaghazi) event.getObject())
						.getFirstname()
						.concat(" ")
						.concat(((MoshakhasateMotaghazi) event.getObject())
								.getLastname()));

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}