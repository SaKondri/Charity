package com.friends.charity.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.friends.charity.business.logic.CalendarFormat;

@Entity
@Table(name = "MAMORIN_TAHGHIGH")
public class MamorinTahghigh extends User {
	private String code;
	@Transient
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
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStrDate() {
		if (getDate() != null) {
			strDate = CalendarFormat.getStrForDT(getDate());
		}
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

}
