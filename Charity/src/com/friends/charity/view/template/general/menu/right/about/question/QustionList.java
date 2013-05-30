package com.friends.charity.view.template.general.menu.right.about.question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.friends.charity.model.admin.about.Qustion;

@Named
@SessionScoped
public class QustionList implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Qustion> qustions;

	public List<Qustion> getQustions() {
		if(qustions == null){
			qustions = new ArrayList<>();
		}
		return qustions;
	}

	public void setQustions(List<Qustion> qustions) {
		this.qustions = qustions;
	}
	
	
}
