package com.friends.charity.view.template.admin.menu;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.view.template.admin.menu.file.register.mamorinTahghigh.MamorinTahghighPage;

@Named
@SessionScoped
public class AdminMenuBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private MamorinTahghighPage mamorinTahghighPage;

	public MamorinTahghighPage getMamorinTahghighPage() {
		return mamorinTahghighPage;
	}

	public void setMamorinTahghighPage(MamorinTahghighPage mamorinTahghighPage) {
		this.mamorinTahghighPage = mamorinTahghighPage;
	}

}
