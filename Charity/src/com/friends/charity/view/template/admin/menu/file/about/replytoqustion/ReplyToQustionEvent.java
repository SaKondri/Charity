package com.friends.charity.view.template.admin.menu.file.about.replytoqustion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.friends.charity.business.logic.Utils;
import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.admin.about.Qustion;
import com.friends.charity.model.admin.about.Response;

@Named
public class ReplyToQustionEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	private GeneralService generalService;
	private String qustionPrivateSize;
	private String qustionPublicSize ;
	private DataModel<Qustion> dataModel;
	public DataModel<Qustion> getDataModel() {
		if(dataModel == null){
			dataModel = new ListDataModel<>();
			dataModel.setWrappedData(getQustions());
			
		}
		return dataModel;
	}
	public String getQustionPrivateSize() {
		return qustionPrivateSize;
	}
	public void setQustionPrivateSize(String qustionPrivateSize) {
		this.qustionPrivateSize = qustionPrivateSize;
	}
	public String getQustionPublicSize() {
		if(size() >0 && size() !=null){
			qustionPublicSize="("+size().toString()+")";
		}
		return qustionPublicSize;
	}
	public void setQustionPublicSize(String qustionPublicSize) {
		this.qustionPublicSize = qustionPublicSize;
	}
	private List<Qustion> qustions;
	private Qustion qustion;
	private Response response;
	@PostConstruct
	public void init(){
		size();
		getQustionsNoReply();
	}
	public List<Qustion> getQustions() {
		if(qustions == null){
			qustions = new ArrayList<>();
			qustions = getQustionsNoReply();
		}
		return qustions;
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
		if(response == null){
			response = new Response();
		}
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	public Long size() {
		Long size = getGeneralService().tableSize("selectDontReplayQustion");
		return size;
	}
	
	public Qustion getQustion() {
		if(qustion == null){
			qustion = new Qustion();
		}
		return qustion;
	}
	public void setQustion(Qustion qustion) {
		this.qustion = qustion;
	}
	public List<Qustion> getQustionsNoReply(){
		List<Qustion> qustions = new ArrayList<>();
		qustions = getGeneralService().selectList("qustionsNoReply", null);
		return qustions;
	}
	public String getReqId(ActionEvent actionEvent){
		Utils.setSession("replyToQustionValue", getDataModel().getRowData());
		return null;
	}
	public String btnReplyToQustion(ActionEvent actionEvent){
		setQustion((Qustion) Utils.getSession("replyToQustionValue"));
		getQustion().setResponse(getResponse());
		try {
			getGeneralService().update(getQustion());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO , "", "پرسش با موفقیت پاسخ داده شد." ));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
