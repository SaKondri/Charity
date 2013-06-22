package com.friends.charity.view.template.MamorTahghigh.menu.center;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class MamorProfilePage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private MamorProfileEvent event;

	public MamorProfileEvent getEvent() {
		return event;
	}

	public void setEvent(MamorProfileEvent event) {
		this.event = event;
	}

}
