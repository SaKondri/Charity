package com.friends.charity.view.template.general.menu;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.friends.charity.view.template.menu.file.resigister.MadadjoRegPage;

@ManagedBean(name="MenuBean")
@ViewScoped
public class MenuBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private MadadjoRegPage madadjoRegPage;

	public MadadjoRegPage getMadadjoRegPage() {
		if (madadjoRegPage == null) {
			madadjoRegPage = new MadadjoRegPage();
		}
		return madadjoRegPage;
	}

	public void setMadadjoRegPage(MadadjoRegPage madadjoRegPage) {
		this.madadjoRegPage = madadjoRegPage;
	}

}
