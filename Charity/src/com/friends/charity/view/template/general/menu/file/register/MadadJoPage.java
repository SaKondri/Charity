package com.friends.charity.view.template.general.menu.file.register;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import com.friends.charity.business.logic.CalendarFormat;
import com.friends.charity.dao.GeneralDao;
import com.friends.charity.model.MoshakhasateMotaghazi;
import com.friends.charity.model.UsernamePassword;
import com.friends.charity.view.template.general.menu.file.register.event.CalendarConvertor;

@Named
@SessionScoped
public class MadadJoPage implements Serializable {
	private static final long serialVersionUID = 1L;
	private MoshakhasateMotaghazi motaghazi;
	private UsernamePassword usernamePassword;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void btn(ActionEvent actionEvent) {
		GeneralDao dao = new GeneralDao();
		getMotaghazi().setBirthday(CalendarFormat.getGerigorian(getDate()));
		System.out.println(getMotaghazi().getBirthday().getTime());
		try {
			dao.save(getMotaghazi());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
