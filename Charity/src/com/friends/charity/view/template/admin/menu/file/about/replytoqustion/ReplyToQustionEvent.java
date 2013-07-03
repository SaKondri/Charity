package com.friends.charity.view.template.admin.menu.file.about.replytoqustion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.friends.charity.business.logic.Utils;
import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.admin.about.Qustion;
import com.friends.charity.model.admin.about.QustionTemp;
import com.friends.charity.model.admin.about.Response;
import com.friends.charity.view.template.general.GeneralEvent;

@Named

public class ReplyToQustionEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private GeneralEvent event;
	private GeneralService generalService;
	private String qustionPrivateSize;
	private String qustionPublicSize;
	private DataModel<QustionTemp> dataModel;
	private List<QustionTemp> qustionTemps;
	private QustionTemp qustionTemp;

	public QustionTemp getQustionTemp() {
		if (qustionTemp == null) {
			qustionTemp = new QustionTemp();
		}
		return qustionTemp;
	}

	public void setQustionTemp(QustionTemp qustionTemp) {
		this.qustionTemp = qustionTemp;
	}

	public List<QustionTemp> getQustionTemps() {
		if (qustionTemps == null) {
			qustionTemps = new ArrayList<>();
			qustionTemps = getQustionsNoReply();
		}
		return qustionTemps;
	}

	public void setQustionTemps(List<QustionTemp> qustionTemps) {
		this.qustionTemps = qustionTemps;
	}

	public DataModel<QustionTemp> getDataModel() {
		if (dataModel == null) {
			dataModel = new ListDataModel<>();
			dataModel.setWrappedData(getQustionTemps());

		}
		return dataModel;
	}

	public GeneralEvent getEvent() {
		return event;
	}

	public void setEvent(GeneralEvent event) {
		this.event = event;
	}

	public String getQustionPrivateSize() {
		return qustionPrivateSize;
	}

	public void setQustionPrivateSize(String qustionPrivateSize) {
		this.qustionPrivateSize = qustionPrivateSize;
	}

	public String getQustionPublicSize() {
		if (size() > 0 && size() != null) {
			qustionPublicSize = "(" + size().toString() + ")";
		}
		return qustionPublicSize;
	}

	public void setQustionPublicSize(String qustionPublicSize) {
		this.qustionPublicSize = qustionPublicSize;
	}

	private List<Qustion> qustions;
	private Qustion qustion;
	private Response response;

	
	public ReplyToQustionEvent() {
		size();
		getQustionsNoReply();
	}

	public void setQustions(List<Qustion> qustions) {
		this.qustions = qustions;
	}

	public GeneralService getGeneralService() {
		if (generalService == null) {
			generalService = new GeneralService();
		}
		return generalService;
	}

	public Response getResponse() {
		if (response == null) {
			response = new Response();
		}
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public Long size() {
		Long size = getGeneralService().tableSize("sizeTempQustionTable");
		return size;
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

	public List<QustionTemp> getQustionsNoReply() {
		List<QustionTemp> qustionTemps = new ArrayList<>();
		qustionTemps = getGeneralService().selectList("allTempQustion", null);
		return qustionTemps;
	}

	public String getReqId(ActionEvent actionEvent) {
		Utils.setSession("replyToQustionValue", getDataModel().getRowData());
		return null;
	}

	public String btnDeleteQustion(ActionEvent actionEvent) {
		try {
			getGeneralService().delete(Utils.getSession("replyToQustionValue"));
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"پرسش با موفقیت حذف شد."));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String btnReplyToQustion(ActionEvent actionEvent) {
		setQustionTemp((QustionTemp) Utils.getSession("replyToQustionValue"));
		try {
			getGeneralService().delete(Utils.getSession("replyToQustionValue"));
		} catch (Exception e1) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e1
							.getMessage()));
			e1.printStackTrace();
		}
		getQustionTemp().setResponse(getResponse());
		try {
			getQustion().setfName(getQustionTemp().getfName());
			getQustion().setTitle(getQustionTemp().getTitle());
			getQustion().setDescription(getQustionTemp().getDescription());
			getQustion().setResponse(getQustionTemp().getResponse());
			getGeneralService().save(getQustion());
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"پرسش با موفقیت پاسخ داده شد."));

		} catch (Exception e) {

		}
		getEvent()
				.setAdminChangePage(
						"/WEB-INF/template/admin/protect/menu/file/about/replytoqustion/replytoqustion.xhtml");
		return null;
	}
}
