package com.friends.charity.view.template.admin.menu.file.about.telAndAdr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.kheyrieConf.Address;
import com.friends.charity.model.kheyrieConf.Phone;
import com.friends.charity.model.kheyrieConf.TelAdd;

@ManagedBean(name = "telAndAdrPage")
@ViewScoped
public class TelAndAdrPage implements Serializable {
	private static final long serialVersionUID = 1L;
	private TelAdd telAdd;
	private Phone phone;
	private Address address;
	private GeneralService service;

	public TelAdd getTelAdd() {
		if (telAdd == null) {
			telAdd = new TelAdd();
		}
		return telAdd;
	}

	public void setTelAdd(TelAdd telAdd) {
		this.telAdd = telAdd;
	}

	public Phone getPhone() {
		if (phone == null) {
			phone = new Phone();
		}
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		if (address == null) {
			address = new Address();
		}
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public GeneralService getService() {
		if (service == null) {
			service = new GeneralService();
		}
		return service;
	}

	public void btnAddPhone(ActionEvent event) {
		getPhone().setTelAdd(getTelAdd());
		getTelAdd().getPhones().add(getPhone());
		setPhone(null);
	}

	public void btnAddAddress(ActionEvent event) {
		getAddress().setTelAdd(getTelAdd());
		getTelAdd().getAddresses().add(getAddress());
		setAddress(null);
	}

	public void btnSaved(ActionEvent actionEvent) {
		try {
			getService().save(getTelAdd());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"ذخیره شد.", "تلفن ها و آدرس ها تنطیم شد.");
			FacesContext.getCurrentInstance().addMessage(null, message);
			setTelAdd(null);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ذخیره نشد.",
					"مجدد امتحان بفرمائید.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

}
