package com.friends.charity.view.template.MotaghaziPrivate.menu.center;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.view.template.MotaghaziPrivate.menu.center.event.ProfileEvent;

@Named
@RequestScoped
public class ProfilePage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private ProfileEvent event;

	public ProfileEvent getEvent() {
		return event;
	}

	public void setEvent(ProfileEvent event) {
		this.event = event;
	}

}
