package com.friends.charity.view.template.general.menu.right.about.question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.friends.charity.business.service.GeneralService;

@Named

public class QustionChangePage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private QustionList qustionList;
	private List<String> buttonName;
	private GeneralService generalService;

	private Long size;

	
	public QustionChangePage() {
		listSize();
	}

	public GeneralService getGeneralService() {
		if (generalService == null) {
			generalService = new GeneralService();
		}
		return generalService;
	}

	public List<String> getButtonName() {
		if (buttonName == null) {
			buttonName = new ArrayList<>();
		}
		return buttonName;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public void setButtonName(List<String> buttonName) {
		this.buttonName = buttonName;
	}

	public QustionList getQustionList() {
		return qustionList;
	}

	public void setQustionList(QustionList qustionList) {
		this.qustionList = qustionList;
	}

	public String listSize() {
		setSize(getGeneralService().tableSize("qustionTableSize"));
		Long btnMod = (long) 0;
		Long btnSize = getSize() / 10;
		Long mod = getSize() % 10;
		for (Integer i = 1; i <= btnSize; i++) {
			getButtonName().add(i.toString());
			btnMod++;
		}
		if (mod > 0) {
			btnMod++;
			getButtonName().add(btnMod.toString());
		}
		return null;
	}

	public String btnPage(ActionEvent actionEvent) {
		HttpServletRequest req = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		Integer btnValue = Integer.parseInt(req.getParameter("btnName"));
		req.getSession().setAttribute("btnValue", btnValue);
		Long size = getGeneralService().tableSize("qustionTableSize");
		Integer mod = (int) (size % 10);
		Integer first = btnValue * 10;
		if (size >= first) {
			getQustionList().setQustions(
					getGeneralService().selectListValue(first - 10, 10));
		} else if (size < first) {
			first = first - 10;
			getQustionList().setQustions(
					getGeneralService().selectListValue(first, mod));
		}
		return null;
	}

	public String btnUpdate() {
		HttpServletRequest req = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		
		Integer btnValue = (Integer) req.getSession().getAttribute("btnValue");
		if (btnValue == null || btnValue == 0) {
			btnValue = 1;
		}
			long size = getGeneralService().tableSize("qustionTableSize");
			Integer mod = (int) (size % 10);
			Integer first = btnValue * 10;
			if (size >= first) {
				getQustionList().setQustions(
						getGeneralService().selectListValue(first - 10, 10));
			} else if (size < first) {
				first = first - 10;
				getQustionList().setQustions(
						getGeneralService().selectListValue(first, mod));
			}
		
		return null;
	}
}
