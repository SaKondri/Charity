package com.friends.charity.view.template.admin.menu.barresi.dialog.ersalBeMamor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.bytecode.stackmap.BasicBlock.Catch;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.MamorinTahghigh;
import com.friends.charity.model.MoshakhasateMotaghazi;

//@ManagedBean(name = "mamorinDlgPage")
//@ViewScoped
@Named
@SessionScoped
public class MamorinDlgPage implements Serializable {
	private static final long serialVersionUID = 1L;
	private DataModel<MamorinTahghigh> dataModel;
	private List<MamorinTahghigh> mamorinTahghighs;
	private GeneralService service;
	private String str;

	public List<MamorinTahghigh> getMamorinTahghighs() {
		if (mamorinTahghighs == null) {
			mamorinTahghighs = new ArrayList<>();
		}
		return mamorinTahghighs;
	}

	public void setMamorinTahghighs(List<MamorinTahghigh> mamorinTahghighs) {
		this.mamorinTahghighs = mamorinTahghighs;
	}

	public DataModel<MamorinTahghigh> getDataModel() {
		if (dataModel == null) {
			dataModel = new ListDataModel<>();
			dataModel.setWrappedData(getMamorinTahghighs());
		}
		return dataModel;
	}

	public void setDataModel(DataModel<MamorinTahghigh> dataModel) {
		this.dataModel = dataModel;
	}

	public GeneralService getService() {
		if (service == null) {
			service = new GeneralService();
		}
		return service;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public void btnMamorInfo(ActionEvent actionEvent) {
		setStr((String) ((HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest()).getParameter("idMar"));
		List<MamorinTahghigh> list;
		try {
			list = getService().selectList("selectMamor", null);
			mamorinTahghighs = new ArrayList<>();
			for (MamorinTahghigh mamorinTahghigh : list) {
				getMamorinTahghighs().add(mamorinTahghigh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void send(ActionEvent actionEvent) {
		int count = 0;
		long id = Long.parseLong(getStr());
		try {
			MoshakhasateMotaghazi motaghazi = getService().select("selectUser",
					id);
			MoshakhasateMotaghazi motgh = motaghazi;
			for (MamorinTahghigh mamor : getMamorinTahghighs()) {
				if (mamor.isState()) {
					count++;
					mamor.getMotaghazis().add(motgh);
					getService().update(mamor);

				}
			}
			if (count < 2 || count > 2) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"انتخاب دو مامور الزامی است.",
								"مجددا سعی کنید."));
				return;
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"ارسال شد", "منتظر جواب باشید!"));
			}

		} catch (Exception exception) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ارسال نشد",
							"مجددا سعی کنید."));
		}

	}
}
