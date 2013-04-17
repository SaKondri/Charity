package com.friends.charity.view.template.MotaghaziPrivate.menu.north;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.view.template.MotaghaziPrivate.menu.north.event.NorthEvent;

@Named
public class NorthMenuPage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private NorthEvent event;

	public String btnLogOut() {
		return getEvent().btnLogOut();
	}

	public NorthEvent getEvent() {
		return event;
	}

	public void setEvent(NorthEvent event) {
		this.event = event;
	}

}
