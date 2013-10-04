package com.friends.charity.view.template.general.menu.right.about.addressAndTell;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.kheyrieConf.Address;
import com.friends.charity.model.kheyrieConf.Phone;
import com.friends.charity.model.kheyrieConf.TelAdd;

@ManagedBean(name = "generalAddAndTellPage")
@ViewScoped
public class GeneralAddAndTellPage implements Serializable {
	private static final long serialVersionUID = 1L;
	private TelAdd telAdd;
	private List<Address> addresses;
	private List<Phone> phones;
	private GeneralService service;

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

	public GeneralService getService() {
		if (service == null) {
			service = new GeneralService();
		}
		return service;
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

			setAddresses(adds);
			setPhones(phs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
