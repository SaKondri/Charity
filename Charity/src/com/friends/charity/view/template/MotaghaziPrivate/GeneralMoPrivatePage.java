package com.friends.charity.view.template.MotaghaziPrivate;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.view.template.MotaghaziPrivate.menu.event.GeneralEventPrivate;
import com.friends.charity.view.template.MotaghaziPrivate.menu.north.NorthMenuPage;

@Named
@SessionScoped
public class GeneralMoPrivatePage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private NorthMenuPage northMenuPage;
	@Inject
	private GeneralEventPrivate generalEventPrivate;

	public NorthMenuPage getNorthMenuPage() {
		return northMenuPage;
	}

	public void setNorthMenuPage(NorthMenuPage northMenuPage) {
		this.northMenuPage = northMenuPage;
	}

	public GeneralEventPrivate getGeneralEventPrivate() {
		return generalEventPrivate;
	}

	public void setGeneralEventPrivate(GeneralEventPrivate generalEventPrivate) {
		this.generalEventPrivate = generalEventPrivate;
	}

}