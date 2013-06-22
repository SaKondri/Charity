package com.friends.charity.view.template.MamorTahghigh.menu.north;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.view.template.MamorTahghigh.menu.north.event.NorthmamorEvent;

@RequestScoped
@Named
public class MamorNorthMenuPage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private NorthmamorEvent event;

	public NorthmamorEvent getEvent() {
		return event;
	}

	public void setEvent(NorthmamorEvent event) {
		this.event = event;
	}

	public String btnLogout() {
		return getEvent().btnLogout();
	}
}
