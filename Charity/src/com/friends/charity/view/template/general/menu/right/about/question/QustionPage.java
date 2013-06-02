package com.friends.charity.view.template.general.menu.right.about.question;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.admin.about.Qustion;
import com.friends.charity.model.admin.about.Response;

@Named
@RequestScoped
public class QustionPage implements Serializable {
	private static final long serialVersionUID = 1L;
	private Qustion qustion;
	private GeneralService dao;
	@Inject
	private QustionList qustionList;
	private Response response;
	public Response getResponse() {
		if(response == null){
			response = new Response();
		}
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	public GeneralService getDao() {
		if(dao == null){
			dao = new GeneralService();
		}
		return dao;
	}
	public void setDao(GeneralService dao) {
		this.dao = dao;
	}
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
	//ایجاد پرسش
	public String btnCreateQuestion(ActionEvent actionEvent) {
		qustionList.getQustions().add(getQustion());
		for (Qustion qu : qustionList.getQustions()) {
			try {
				getDao().saveOrUpdate(qu);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FacesContext.getCurrentInstance().addMessage(
				"frmMenuQuestion",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "پرسش",
						"با موفقیت ارسال شد"));
		
		setQustion(new Qustion());
		return null;
	}
	//ثبت
	public String btnResponseforQustion(ActionEvent actionEvent){
		HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		Long id=(Long) request.getSession().getAttribute("idRequest");
		for (Qustion qu : qustionList.getQustions()) {
			try {
				if(qu.getId() == id){
					qu.setResponse(getResponse());
					getDao().saveOrUpdate(qu);
				}
					
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		return null;
	}
	//پاسخ
	public void btnResponce(ActionEvent actionEvent){
		HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		reqId();
		
	}
	public void reqId(){
		String id=((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("idRequest");
		Long i =Long.parseLong(id);
		HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		request.getSession(true).setAttribute("idRequest", i);
	}
}
