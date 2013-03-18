package com.friends.charity.view.template.general.menu.file.register.event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import com.friends.charity.model.MoshakhasateMotaghazi;
import com.friends.charity.model.UsernamePassword;
import com.friends.charity.model.farzand.Farzandan;

@Named
public class MadadJoEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	private MoshakhasateMotaghazi motaghazi;
	private UsernamePassword usernamePassword;
	private List<Farzandan> farzandans;
	private DataModel<Farzandan> dataModel;
	private Farzandan farzandan;
	private Date date;

	public MoshakhasateMotaghazi getMotaghazi() {
		if (motaghazi == null) {
			motaghazi = new MoshakhasateMotaghazi();
		}
		return motaghazi;
	}

	public void setMotaghazi(MoshakhasateMotaghazi motaghazi) {
		this.motaghazi = motaghazi;
	}

	public UsernamePassword getUsernamePassword() {
		if (usernamePassword == null) {
			usernamePassword = new UsernamePassword();
		}
		return usernamePassword;
	}

	public void setUsernamePassword(UsernamePassword usernamePassword) {
		this.usernamePassword = usernamePassword;
	}

	public List<Farzandan> getFarzandans() {
		if (farzandans == null) {
			farzandans = new ArrayList<>();
		}
		return farzandans;
	}

	public void setFarzandans(List<Farzandan> farzandans) {
		this.farzandans = farzandans;
	}

	public DataModel<Farzandan> getDataModel() {
		if (dataModel == null) {
			dataModel = new ListDataModel<>();
			dataModel.setWrappedData(getFarzandans());
		}
		return dataModel;
	}

	public void setDataModel(DataModel<Farzandan> dataModel) {
		this.dataModel = dataModel;
	}

	public Farzandan getFarzandan() {
		if (farzandan == null) {
			farzandan = new Farzandan();
		}
		return farzandan;
	}

	public void setFarzandan(Farzandan farzandan) {
		this.farzandan = farzandan;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * .برای دکمه ثبت
	 */
	public void btnSubmit(ActionEvent event) {
		getFarzandans().add(getFarzandan());
		setFarzandan(null);
	}

	/**
	 * for birthday commite
	 * 
	 * public void btn(ActionEvent actionEvent) { GeneralDao dao = new
	 * GeneralDao();
	 * getMotaghazi().setBirthday(CalendarFormat.getGerigorian(getDate()));
	 * System.out.println(getMotaghazi().getBirthday().getTime()); try {
	 * dao.save(getMotaghazi()); } catch (Exception e) { e.printStackTrace(); }
	 */
}
