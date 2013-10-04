package com.friends.charity.model.kheyrieConf;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.friends.charity.model.BaseEntity;

@Table(name = "TEL_ADD")
@Entity
@NamedQueries({
	@NamedQuery(name="allTelAdd",query="select ta from TelAdd ta")
})
public class TelAdd extends BaseEntity {
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "telAdd")
	private List<Phone> phones;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "telAdds")
	private List<Address> addresses;

	public List<Phone> getPhones() {
		if (phones == null) {
			phones = new ArrayList<>();
		}
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
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

}
