package com.friends.charity.view.template.MotaghaziPrivate.menu.east.dialog.event;

import java.io.Serializable;
import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import com.friends.charity.business.logic.CalendarFormat;
import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.BargehMakhsosTaghazaNameh;

@Named
public class TaghazaNamehEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	private BargehMakhsosTaghazaNameh nameh;
	private GeneralService generalService;

	public BargehMakhsosTaghazaNameh getNameh() {
		if (nameh == null) {
			nameh = new BargehMakhsosTaghazaNameh();
		}
		return nameh;
	}

	public void setNameh(BargehMakhsosTaghazaNameh nameh) {
		this.nameh = nameh;
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

	public void btnSend(ActionEvent actionEvent) {
		FacesMessage message = new FacesMessage();
		FacesContext context = FacesContext.getCurrentInstance();
		if(getNameh().getTempDate()==null){
			getNameh().setCal(Calendar.getInstance());
		}else{
		getNameh().setCal(
				CalendarFormat.getGerigorian(getNameh().getTempDate()));
		}
		try {
			getGeneralService().save(getNameh());
			nullEntity();
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setDetail("ذخیره");
			message.setSummary("اطلاعات شما با موفقیت ذخیره شد");
			context.addMessage(null, message);

		} catch (Exception e) {
			nullEntity();
			message.setSeverity(FacesMessage.SEVERITY_FATAL);
			message.setDetail("خطا");
			message.setSummary("مجددا امتحان فرمائید.");
			context.addMessage(null, message);

			e.printStackTrace();
		}
	}

	private void nullEntity() {
		setNameh(null);
	}
//	.fileupload-buttonbar {
//		background: transparent;
//		border: none;
//	}
//
//	.fileupload-content {
//		display: inline-table;
//	}
//
//	.ui-fileupload .fileinput-button {
//		background-color: rgba(142, 103, 64, 0.98);
//	}

}
