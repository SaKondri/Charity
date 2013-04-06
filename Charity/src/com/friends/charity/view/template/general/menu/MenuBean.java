package com.friends.charity.view.template.general.menu;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.view.template.general.menu.file.register.MadadJoPage;

@Named
@SessionScoped
public class MenuBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private MadadJoPage madadJoPage;

	public MadadJoPage getMadadJoPage() {
		return madadJoPage;
	}

	public void setMadadJoPage(MadadJoPage madadJoPage) {
		this.madadJoPage = madadJoPage;
	}

}
