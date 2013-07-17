package com.friends.charity.view.template.admin.menu.barresi;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.view.template.admin.menu.barresi.event.MadadjoListEvent;

@Named(value = "testBean")
@SessionScoped
public class MadadjoListPage implements Serializable {
	/**
	 * 
	 */
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