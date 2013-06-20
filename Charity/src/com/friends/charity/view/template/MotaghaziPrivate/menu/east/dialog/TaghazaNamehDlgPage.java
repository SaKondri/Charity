package com.friends.charity.view.template.MotaghaziPrivate.menu.east.dialog;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.view.template.MotaghaziPrivate.menu.east.dialog.event.TaghazaNamehEvent;

@RequestScoped
@Named
public class TaghazaNamehDlgPage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private TaghazaNamehEvent event;

	public TaghazaNamehEvent getEvent() {
		return event;
	}

	public void setEvent(TaghazaNamehEvent event) {
		this.event = event;
	}

}
