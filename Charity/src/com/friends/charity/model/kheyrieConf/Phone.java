package com.friends.charity.model.kheyrieConf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.friends.charity.model.BaseEntity;

@Entity
@Table(name = "PHONE")
public class Phone extends BaseEntity {
	@Column(name = "PHONE_NUM")
	private String phoneNum;
	@ManyToOne
	private TelAdd telAdd;

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
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

}
