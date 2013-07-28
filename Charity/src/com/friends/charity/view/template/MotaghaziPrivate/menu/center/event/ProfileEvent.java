package com.friends.charity.view.template.MotaghaziPrivate.menu.center.event;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.friends.charity.business.logic.CalendarFormat;
import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.Login;
import com.friends.charity.model.MaskanType;
import com.friends.charity.model.MoshakhasateMotaghazi;
import com.friends.charity.model.NiazMotaghazii;

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

	public SelectItem[] getMaskanValue() {
		SelectItem items[] = new SelectItem[MaskanType.values().length];
		int i = 0;
		for (MaskanType g : MaskanType.values()) {
			items[i++] = new SelectItem(g, g.getType());
		}
		return items;
	}

	public SelectItem[] getNiazMotaghazi() {
		SelectItem[] items = new SelectItem[NiazMotaghazii.values().length];
		int i = 0;
		for (NiazMotaghazii niazMotaghazii : NiazMotaghazii.values()) {
			items[i++] = new SelectItem(niazMotaghazii,
					niazMotaghazii.getType());
		}
		return items;
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
			getMotaghazi().getUserImage().setHasPic(true);
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

	public void editMySelfCalendar() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		try {
			getMotaghazi().setBirthday(
					CalendarFormat
							.getGerigorian(getMotaghazi().getMySelfDate()));
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

	public void editMyWifeCalendar() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		try {
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