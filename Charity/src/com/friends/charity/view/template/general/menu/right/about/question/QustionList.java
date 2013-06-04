package com.friends.charity.view.template.general.menu.right.about.question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Named;
import javax.validation.Constraint;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.admin.about.Qustion;
import com.sun.xml.rpc.encoding.soap.CollectionSerializer;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.javaIdentifierType;
import com.sun.xml.wss.saml.assertion.saml11.jaxb10.Action;

@Named
public class QustionList implements Serializable  {
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
			qustions = getAllQustion();
			
		}
		return qustions;
	}

	public void setQustions(List<Qustion> qustions) {
		this.qustions = qustions;
	}

	public List<Qustion> getAllQustion() {
		List<Qustion> qustions = new ArrayList<>();
		try {
			qustions = getDao().selectList("allQustions", null);

		} catch (Exception e1) {
			System.out
					.println("eerrror in select QustionList ==============>>>>>>>"
							+ e1.getMessage());
		}

		return qustions;
	}
	
	
}
