package com.friends.charity.view.template.MamorTahghigh.menu.center;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.friends.charity.business.logic.CalendarFormat;
import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.Login;
import com.friends.charity.model.MamorinTahghigh;
import com.friends.charity.model.MoshakhasateMotaghazi;

@Named
public class MamorProfileEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	private Login login;
	private MamorinTahghigh mamorinTahghigh;
	private GeneralService generalService;

	public Login getLogin() {
		login = ((Login) ((HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest())
				.getSession().getAttribute("mamorLogin"));
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public MamorinTahghigh getMamorinTahghigh() {
		mamorinTahghigh = (MamorinTahghigh) getLogin().getUser();
		return mamorinTahghigh;
	}

	public void setMamorinTahghigh(MamorinTahghigh mamorinTahghigh) {
		this.mamorinTahghigh = mamorinTahghigh;
	}

	public GeneralService getGeneralService() {
		if (generalService == null) {
			generalService = new GeneralService();
		}
		return generalService;
	}

	public void setGeneralService(GeneralService generalService) {
		this.generalService = generalService;
	}

	public StreamedContent getImage() {
		MoshakhasateMotaghazi mo = (MoshakhasateMotaghazi) getLogin().getUser();
		byte[] image = mo.getUserImage().getImage();
		if (image == null) {
			return new DefaultStreamedContent();
		}
		StreamedContent content = new DefaultStreamedContent(
				new ByteArrayInputStream(image));
		return content;
	}

	public void savedEditeHandle() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		try {
			getLogin().setUser(getMamorinTahghigh());
			getGeneralService().saveOrUpdate(getLogin());
			message.setDetail(" ویرایش مشخصات.");
			message.setSummary("ویرایش صورت گرفت.");
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			context.addMessage(null, message);
		} catch (Exception e) {
			message.setDetail("خطا در ویرایش.");
			message.setSummary("ویرایش صورت نگرفت.");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, message);
			e.printStackTrace();
		}
	}

	public void editCalendar() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		try {
			getMamorinTahghigh().setBirthday(
					CalendarFormat
							.getGerigorian(getMamorinTahghigh().getDate()));
			getLogin().setUser(getMamorinTahghigh());
			getGeneralService().saveOrUpdate(getLogin());
			message.setDetail(" ویرایش مشخصات.");
			message.setSummary("ویرایش صورت گرفت.");
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			context.addMessage(null, message);
		} catch (Exception e) {
			message.setDetail("خطا در ویرایش.");
			message.setSummary("ویرایش صورت نگرفت.");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, message);
			e.printStackTrace();
		}
	}

}
