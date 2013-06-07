package com.friends.charity.view.template.general.menu.right.about.question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.admin.about.Qustion;

@Named
@RequestScoped
public class QustionList implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Qustion> qustions;

	private GeneralService dao;

	public GeneralService getDao() {
		if (dao == null) {
			dao = new GeneralService();
		}
		return dao;
	}

	public void setDao(GeneralService dao) {
		this.dao = dao;
	}

	public List<Qustion> getQustions() {
		if (qustions == null) {
			qustions = new ArrayList<>();
			qustions = getDao().selectListValue(0, 10);

		}
		return qustions;
	}

	public void setQustions(List<Qustion> qustions) {
		this.qustions = qustions;
	}

}
