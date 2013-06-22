package com.friends.charity.view.template.admin.menu.file.register.mamorinTahghigh;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.view.template.admin.menu.file.register.mamorinTahghigh.event.MamorinEvent;

@Named
public class MamorinTahghighPage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private MamorinEvent event;

	public MamorinEvent getEvent() {
		return event;
	}

	public void setEvent(MamorinEvent event) {
		this.event = event;
	}

}
