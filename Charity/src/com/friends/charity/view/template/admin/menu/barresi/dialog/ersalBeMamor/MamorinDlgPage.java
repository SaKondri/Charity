package com.friends.charity.view.template.admin.menu.barresi.dialog.ersalBeMamor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.CloseEvent;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.MamorMotaghazi;
import com.friends.charity.model.MamorMovaghat;
import com.friends.charity.model.MamorinTahghigh;
import com.friends.charity.model.MoshakhasateMotaghazi;

@Named
public class MamorinDlgPage implements Serializable {
	private static final long serialVersionUID = 1L;
	private DataModel<MamorinTahghigh> dataModel;
	private List<MamorinTahghigh> mamorinTahghighs;
	private GeneralService service;
	private String str;
	private boolean addTemporaryMamor = false;
	private MamorMovaghat mamorMovaghat;
	private List<MamorMotaghazi> mamorMotaghazis;

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

	public boolean isAddTemporaryMamor() {
		return addTemporaryMamor;
	}

	public void setAddTemporaryMamor(boolean addTemporaryMamor) {
		this.addTemporaryMamor = addTemporaryMamor;
	}

	public MamorMovaghat getMamorMovaghat() {
		if (mamorMovaghat == null) {
			mamorMovaghat = new MamorMovaghat();
		}
		return mamorMovaghat;
	}

	public void setMamorMovaghat(MamorMovaghat mamorMovaghat) {
		this.mamorMovaghat = mamorMovaghat;
	}

	public List<MamorMotaghazi> getMamorMotaghazis() {
		if (mamorMotaghazis == null) {
			mamorMotaghazis = new ArrayList<>();
		}
		return mamorMotaghazis;
	}

	public void setMamorMotaghazis(List<MamorMotaghazi> mamorMotaghazis) {
		this.mamorMotaghazis = mamorMotaghazis;
	}

	public void btnAddTemp(ActionEvent actionEvent) {
		setAddTemporaryMamor(true);
	}

	public void btnClose(CloseEvent closeEvent) {
		setAddTemporaryMamor(false);
		setMamorMovaghat(null);
	}

	public void btnMamorInfo(ActionEvent actionEvent) {
		setStr((String) ((HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest()).getParameter("idMar"));
		setMamorins();
	}

	public void setMamorins() {
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

	public void btnAddMovaghat(ActionEvent actionEvent) {
		try {
			getMamorMovaghat().setCode("موقت");
			// getMamorMovaghat().setState(true);
			service.save(getMamorMovaghat());
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"مامور موقت ساخته شد", "موفقیت."));
			setMamorins();

			setMamorMovaghat(null);
		} catch (Exception exception) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"مامور موقت ساخته نشد", "نا موفق."));

		}
	}

	public void send(ActionEvent actionEvent) {
		int count = 0;
		long id = Long.parseLong(getStr());
		MoshakhasateMotaghazi motaghazi = getService().select("selectUser", id);
		// MoshakhasateMotaghazi motgh = motaghazi;
		for (MamorinTahghigh mamor : getMamorinTahghighs()) {
			if (mamor.isState()) {
				MamorMotaghazi mm = new MamorMotaghazi();

				count++;

				mm.setMamorId(mamor.getId());
				mm.setMotaghaziId(motaghazi.getId());

				getMamorMotaghazis().add(mm);
			}
		}
		try {
			if (count < 2 || count > 2) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"انتخاب دو مامور الزامی است.",
								"دقیقا دو مامور اتخاب کنید."));
				setMamorMotaghazis(null);
				return;
			} else {
				for (MamorMotaghazi iterable : getMamorMotaghazis()) {
					getService().save(iterable);
				}
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"ارسال شد.", "منتظر جواب باشید!"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا",
							"ارسال نشد!"));
			e.printStackTrace();
		}
		// motaghazi.getMamors().add(mamor);
		// mamor.getMotaghazis().add(motaghazi);

		// if (count < 2) {
		//
		// if (!(getMamorMovaghat().getFirstname() == null) && count == 1) {
		//
		// FacesContext.getCurrentInstance().addMessage(
		// null,
		// new FacesMessage(FacesMessage.SEVERITY_INFO,
		// "ارسال شد(به همراه یک مامور موقت)",
		// "منتظر جواب باشید!"));
		// return;
		// }
		//
		// FacesContext.getCurrentInstance().addMessage(
		// null,
		// new FacesMessage(FacesMessage.SEVERITY_ERROR,
		// "انتخاب دو مامور الزامی است.",
		// "در صورت لزوم یک مامور موقت ایجاد کنید."));
		// return;
		// } else if (count > 2) {
		// FacesContext.getCurrentInstance()
		// .addMessage(
		// null,
		// new FacesMessage(FacesMessage.SEVERITY_ERROR,
		// "انتخاب دو مامور کافی است.",
		// "یک مورد را حذف کنید."));
		// return;
		// } else {
		// // btnClose(null);
		//
		// FacesContext.getCurrentInstance().addMessage(
		// null,
		// new FacesMessage(FacesMessage.SEVERITY_INFO, "ارسال شد",
		// "منتظر جواب باشید!"));
		// }
	}

	private void nullable() {
		setAddTemporaryMamor(false);
	}
}
