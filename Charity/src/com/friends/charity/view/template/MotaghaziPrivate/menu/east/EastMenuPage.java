package com.friends.charity.view.template.MotaghaziPrivate.menu.east;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class EastMenuPage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private EastMenuEvent event;

	public EastMenuEvent getEvent() {
		return event;
	}

	public void setEvent(EastMenuEvent event) {
		this.event = event;
	}

}
