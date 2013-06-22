package com.friends.charity.view.template.general.pic.switcher;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.view.template.general.pic.switcher.event.ImageSwitcherEvent;

@Named
@SessionScoped
public class ImageSwitcherPage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private ImageSwitcherEvent event;

	public ImageSwitcherEvent getEvent() {
		return event;
	}

	public void setEvent(ImageSwitcherEvent event) {
		this.event = event;
	}

}
