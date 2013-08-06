package com.friends.charity.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.friends.charity.business.logic.CalendarFormat;

@Entity
@Table(name = "MAMORIN_TAHGHIGH")
public class MamorinTahghigh extends User {
	private String code;
	@Column(name = "My_DATE")
	private Date date;
	@Transient
	private String strDate;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		if (date == null) {
			date = new Date();
		}
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStrDate() {
		strDate = CalendarFormat.getStrForDT(getDate());
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

}
