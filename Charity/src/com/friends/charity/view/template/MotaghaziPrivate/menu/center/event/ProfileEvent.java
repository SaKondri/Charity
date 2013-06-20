package com.friends.charity.view.template.MotaghaziPrivate.menu.center.event;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.friends.charity.business.logic.CalendarFormat;
import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.Login;
import com.friends.charity.model.MoshakhasateMotaghazi;

@Named
public class ProfileEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	private Login login;
	private MoshakhasateMotaghazi motaghazi;
	private GeneralService generalService;

	public Login getLogin() {
		login = ((Login) ((HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest())
				.getSession().getAttribute("login"));
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public MoshakhasateMotaghazi getMotaghazi() {
		motaghazi = (MoshakhasateMotaghazi) getLogin().getUser();
		return motaghazi;
	}

	public void setMotaghazi(MoshakhasateMotaghazi motaghazi) {
		this.motaghazi = motaghazi;
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

	public void imageEvent(FileUploadEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		try {
			getMotaghazi().getUserImage().setPicName(
					event.getFile().getFileName());
			getMotaghazi().getUserImage().setImage(
					event.getFile().getContents());
			message.setDetail("ویرایش عکس");
			message.setSummary(".عکس شما با موفقیت ویرایش شد");
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			context.addMessage(null, message);
		} catch (Exception e) {
			message.setDetail("ذخیره عکس");
			message.setSummary(".عکس شما بارگذاری نشد");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, message);
		}
	}

	public void savedEditeHandle() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		try {
			getGeneralService().saveOrUpdate(getMotaghazi());
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
			getMotaghazi().setBirthday(
					CalendarFormat
							.getGerigorian(getMotaghazi().getMySelfDate()));
			getMotaghazi().setHamsarBirthday(
					CalendarFormat
							.getGerigorian(getMotaghazi().getMyWifeDate()));
			getGeneralService().saveOrUpdate(getMotaghazi());
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
