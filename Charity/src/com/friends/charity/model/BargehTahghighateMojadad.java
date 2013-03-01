package com.friends.charity.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.friends.charity.model.BaseEntity;

@Entity
@Table(name = "BARGEH_TAHGHIGHATE_MOJADAD")
public class BargehTahghighateMojadad extends BaseEntity {
	@Column(name = "SHOMAREH")
	private long shomareh;
	@Column(name = "DATE")
	@Temporal(TemporalType.DATE)
	private Calendar date;
	@Column(name = "DAEM")
	private boolean daem;//?
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)// login bahsad va cascade bayad fargh konad
	private MoshakhasateMotaghazi moshakhasateMotaghazi;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private NiazMotaghazi niazMotaghazi;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private GozareshMamorinTahghigh gozareshMamorinTahghigh;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private MosavabateHeyatModireh mosavabateHeyatModireh;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Moarref moarref;
	@Column(name = "NAME_CONTROL_KONANDEH")
	private String NameControlKonandeh;// bayad rabeteye oneToOne bargharar
										// shavad

	public long getShomareh() {
		return shomareh;
	}

	public void setShomareh(long shomareh) {
		this.shomareh = shomareh;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public boolean isDaem() {
		return daem;
	}

	public void setDaem(boolean daem) {
		this.daem = daem;
	}

	public MoshakhasateMotaghazi getMoshakhasateMotaghazi() {
		if (moshakhasateMotaghazi == null) {
			moshakhasateMotaghazi = new MoshakhasateMotaghazi();
		}
		return moshakhasateMotaghazi;
	}

	public void setMoshakhasateMotaghazi(
			MoshakhasateMotaghazi moshakhasateMotaghazi) {
		this.moshakhasateMotaghazi = moshakhasateMotaghazi;
	}

	public NiazMotaghazi getNiazMotaghazi() {
		if (niazMotaghazi == null) {
			niazMotaghazi = new NiazMotaghazi();
		}
		return niazMotaghazi;
	}

	public void setNiazMotaghazi(NiazMotaghazi niazMotaghazi) {
		this.niazMotaghazi = niazMotaghazi;
	}

	public GozareshMamorinTahghigh getGozareshMamorinTahghigh() {
		if (gozareshMamorinTahghigh == null) {
			gozareshMamorinTahghigh = new GozareshMamorinTahghigh();
		}
		return gozareshMamorinTahghigh;
	}

	public void setGozareshMamorinTahghigh(
			GozareshMamorinTahghigh gozareshMamorinTahghigh) {
		this.gozareshMamorinTahghigh = gozareshMamorinTahghigh;
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

	public Moarref getMoarref() {
		if (moarref == null) {
			moarref = new Moarref();
		}
		return moarref;
	}

	public void setMoarref(Moarref moarref) {
		this.moarref = moarref;
	}

	public String getNameControlKonandeh() {
		return NameControlKonandeh;
	}

	public void setNameControlKonandeh(String nameControlKonandeh) {
		NameControlKonandeh = nameControlKonandeh;
	}

}
