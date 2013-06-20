package com.friends.charity.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.friends.charity.business.logic.CalendarFormat;

@Entity
@Table(name = "TARIKH_SABTENAME_KARBAR")
public class TarikhSabteNameKarbar extends BaseEntity {
	@Column(name = "TARIKHEH_SABT")
	@Temporal(TemporalType.DATE)
	private Calendar tarikhehSabt;
	@Column(name = "DATE")
	private Date date;
	@Transient
	private String strDate;

	public Calendar getTarikhehSabt() {
		return tarikhehSabt;
	}

	public void setTarikhehSabt(Calendar tarikhehSabt) {
		this.tarikhehSabt = tarikhehSabt;
	}

	public Date getDate() {
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
