package com.friends.charity.view.template.general.menu.file.register;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.view.template.general.menu.file.register.event.MadadJoEvent;

@Named
@SessionScoped
public class MadadJoPage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private MadadJoEvent event;

	public MadadJoEvent getEvent() {
		return event;
	}

	public void setEvent(MadadJoEvent event) {
		this.event = event;
	}

	public void saved(ActionEvent actionEvent) {
		getEvent().saved(actionEvent);
	}

}
