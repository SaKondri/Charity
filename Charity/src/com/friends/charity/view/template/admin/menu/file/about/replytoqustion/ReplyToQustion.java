package com.friends.charity.view.template.admin.menu.file.about.replytoqustion;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ReplyToQustion implements Serializable{
	private static final long serialVersionUID = 1L;
	@Inject
	private ReplyToQustionEvent event;
	
	
	public ReplyToQustionEvent getEvent() {
		return event;
	}
	public void setEvent(ReplyToQustionEvent event) {
		this.event = event;
	}

}
