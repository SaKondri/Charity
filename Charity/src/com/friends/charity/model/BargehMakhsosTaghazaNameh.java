package com.friends.charity.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.friends.charity.business.logic.CalendarFormat;

@Entity
@Table(name = "BARGEH_MAKHSOS_TAGHAZA_NAMEH")
public class BargehMakhsosTaghazaNameh extends BaseEntity {
	@Column(name = "DATE")
	@Temporal(TemporalType.DATE)
	private Calendar cal;
	@Transient
	private Date tempDate;
	@Transient
	private String strDate;
	@Column(name = "SHOMAREH_PARVANDEH")
	private String shomarehParvandeh;
	@Column(name = "FIRSTNAME_MOTAGHAZI")
	private String firstNameMotaghazi;
	@Column(name = "LASTNAME_MOTAGHAZI")
	private String lastNameMotaghazi;
	@Column(name = "MOZOYETAGHAZA")
	private String mozoyeTaghaza;
	@Column(name = "SHARH", columnDefinition = "text")
	private String sharh;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "TELEPHON")
	private String telephon;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private MosavabateHeyatModireh mosavabateHeyatModireh;

	public Calendar getCal() {
		if (cal == null) {
			cal = Calendar.getInstance();
		}
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}

	public Date getTempDate() {
		return tempDate;
	}

	public void setTempDate(Date tempDate) {
		this.tempDate = tempDate;
	}

	public String getStrDate() {
		strDate = CalendarFormat.getStrForDT(getTempDate());
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	public String getShomarehParvandeh() {
		return shomarehParvandeh;
	}

	public void setShomarehParvandeh(String shomarehParvandeh) {
		this.shomarehParvandeh = shomarehParvandeh;
	}

	public String getFirstNameMotaghazi() {
		return firstNameMotaghazi;
	}

	public void setFirstNameMotaghazi(String firstNameMotaghazi) {
		this.firstNameMotaghazi = firstNameMotaghazi;
	}

	public String getLastNameMotaghazi() {
		return lastNameMotaghazi;
	}

	public void setLastNameMotaghazi(String lastNameMotaghazi) {
		this.lastNameMotaghazi = lastNameMotaghazi;
	}

	public String getMozoyeTaghaza() {
		return mozoyeTaghaza;
	}

	public void setMozoyeTaghaza(String mozoyeTaghaza) {
		this.mozoyeTaghaza = mozoyeTaghaza;
	}

	public String getSharh() {
		return sharh;
	}

	public void setSharh(String sharh) {
		this.sharh = sharh;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephon() {
		return telephon;
	}

	public void setTelephon(String telephon) {
		this.telephon = telephon;
	}

	public MosavabateHeyatModireh getMosavabateHeyatModireh() {
		if (mosavabateHeyatModireh == null) {
			mosavabateHeyatModireh = new MosavabateHeyatModireh();
		}
		return mosavabateHeyatModireh;
	}

	public void setMosavabateHeyatModireh(
			MosavabateHeyatModireh mosavabateHeyatModireh) {
		this.mosavabateHeyatModireh = mosavabateHeyatModireh;
	}

}
