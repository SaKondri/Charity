package com.friends.charity.view.template.admin.menu.barresi;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.friends.charity.view.template.admin.menu.barresi.event.MadadjoListEvent;

@ManagedBean(name = "testBean")
@ViewScoped
public class MadadjoListPage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private MadadjoListEvent event;

	public MadadjoListEvent getEvent() {
		return event;
	}

	public void setEvent(MadadjoListEvent event) {
		this.event = event;
	}

}