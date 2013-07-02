package com.friends.charity.view.template.general.menu.right.about.question;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.jvnet.ws.databinding.DatabindingMode;

import com.friends.charity.business.logic.Utils;
import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.admin.about.Qustion;
import com.friends.charity.model.admin.about.QustionTemp;
import com.friends.charity.model.admin.about.Response;

@Named
@RequestScoped
public class QustionPage implements Serializable {
	private static final long serialVersionUID = 1L;
	private Qustion qustion;
	private QustionTemp qustionTemp;
	private GeneralService dao;
	@Inject
	private QustionList qustionList;
	@Inject
	private QustionChangePage qustionChangePage;
	private Response response;
	
	public QustionTemp getQustionTemp() {
		if(qustionTemp == null){
			qustionTemp = new QustionTemp();
		}
		return qustionTemp;
	}
	public void setQustionTemp(QustionTemp qustionTemp) {
		this.qustionTemp = qustionTemp;
	}
	public QustionChangePage getQustionChangePage() {
		return qustionChangePage;
	}

	public void setQustionChangePage(QustionChangePage qustionChangePage) {
		this.qustionChangePage = qustionChangePage;
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

	public GeneralService getDao() {
		if (dao == null) {
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

	// ایجاد پرسش
	public String btnCreateQuestion(ActionEvent actionEvent) {
		try {
			getDao().save(getQustionTemp());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "پرسش",
						"با موفقیت ارسال شد"));
//		HttpServletRequest request = (HttpServletRequest) FacesContext
	//			.getCurrentInstance().getExternalContext().getRequest();
//		request.getSession().setAttribute("btnValue", 0);
//		getQustionChangePage().btnUpdate();

		setQustionTemp(new QustionTemp());

		return null;
	}

	// ثبت
	public String btnResponseforQustion(ActionEvent actionEvent) {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		Long id = (Long) request.getSession().getAttribute("idRequest");
		setQustion((Qustion) getDao().select("selectById", id));
		getQustion().setResponse(getResponse());
		try {
			getDao().saveOrUpdate(getQustion());
			getQustionChangePage().btnUpdate();
		//	getQustionChangePage().listSize();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, getQustion()
							.getfName(), "پرسش " + getQustion().getfName()
							+ " با موفقیت پاسخ داده شد"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// پاسخ
	public void btnResponce(ActionEvent actionEvent) {
		reqId();

	}

	public void reqId() {
		String id = ((HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest()).getParameter("idRequest");
		Long i = Long.parseLong(id);
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		request.getSession(true).setAttribute("idRequest", i);

	}
}
