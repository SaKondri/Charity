package com.friends.charity.view.template.admin.menu.file.about.telAndAdr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
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
	private List<Address> addresses;
	private List<Phone> phones;
	private DataModel<Address> addressesModel;
	private DataModel<Phone> phonesModel;

	@PostConstruct
	public void init() {
		getFromDB();
	}

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

	public List<Address> getAddresses() {
		if (addresses == null) {
			addresses = new ArrayList<>();
		}
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Phone> getPhones() {
		if (phones == null) {
			phones = new ArrayList<>();
		}
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public DataModel<Address> getAddressesModel() {
		if (addressesModel == null) {
			addressesModel = new ListDataModel<>(getAddresses());
		}
		return addressesModel;
	}

	public void setAddressesModel(DataModel<Address> addressesModel) {
		this.addressesModel = addressesModel;
	}

	public DataModel<Phone> getPhonesModel() {
		if (phonesModel == null) {
			phonesModel = new ListDataModel<>(getPhones());
		}
		return phonesModel;
	}

	public void setPhonesModel(DataModel<Phone> phonesModel) {
		this.phonesModel = phonesModel;
	}

	public void btnAddPhone(ActionEvent event) {
		getPhone().setTelAdd(getTelAdd());
		getPhones().add(getPhone());
		setPhone(null);
	}

	public void btnDeletePhone(ActionEvent event) {
		try {
			Phone phone = getPhonesModel().getRowData();

			getService().delete(phone);
			getPhones().remove(phone);

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"بروز رسانی ...", "تلفن حذف شد.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "تلفن حذف نشد.",
					"مجدد امتحان بفرمائید.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void btnAddAddress(ActionEvent event) {
		getAddress().setTelAdd(getTelAdd());
		getAddresses().add(getAddress());
		setAddress(null);
	}

	public void btnSaved(ActionEvent actionEvent) {
		try {
			getTelAdd().setAddresses(getAddresses());
			getTelAdd().setPhones(getPhones());

			getService().saveOrUpdate(getTelAdd());
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

	public void getFromDB() {
		TelAdd ta = new TelAdd();
		List<Address> adds;
		List<Phone> phs;

		try {
			ta = getService().select("allTelAdd", null);

			Map<String, Object> params = new HashMap<>();
			params.put("telAddId", ta.getId());

			adds = getService().selectList("address", params);
			phs = getService().selectList("phone", params);

			setTelAdd(ta);
			setAddresses(adds);
			setPhones(phs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
