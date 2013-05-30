package com.friends.charity.view.template.general.menu.right.about.question;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.model.admin.about.Qustion;

@Named
@RequestScoped
public class QustionPage implements Serializable {
	private static final long serialVersionUID = 1L;
	private Qustion qustion;
	
	@Inject
	private QustionList qustionList;
	public QustionList getQustionList() {
		return qustionList;
	}
	public void setQustionList(QustionList qustionList) {
		this.qustionList = qustionList;
	}

	public Qustion getQustion() {
		if (qustion == null) {
			qustion = new Qustion();
		}
		return qustion;
	}

	public void setQustion(Qustion qustion) {
		this.qustion = qustion;
	}

	public String btnCreateQuestion(ActionEvent actionEvent) {
		qustionList.getQustions().add(getQustion());
		FacesContext.getCurrentInstance().addMessage(
				"frmMenuQuestion",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "پرسش",
						"با موفقیت ارسال شد"));
		System.out.println("sssssssssssssssssssssssiiiiiiiiizzzzzzzzzzeeeeeeeee"+qustionList.getQustions().size());
		return null;
	}


}
