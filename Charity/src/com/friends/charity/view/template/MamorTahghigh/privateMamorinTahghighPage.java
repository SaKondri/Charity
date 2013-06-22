package com.friends.charity.view.template.MamorTahghigh;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.view.template.MamorTahghigh.event.PrivateMamorEvent;

@RequestScoped
@Named
public class privateMamorinTahghighPage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private PrivateMamorEvent event;

	public PrivateMamorEvent getEvent() {
		return event;
	}

	public void setEvent(PrivateMamorEvent event) {
		this.event = event;
	}

}
