package com.friends.charity.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.friends.charity.business.logic.CalendarFormat;

@Entity
@Table(name = "MAMORIN_TAHGHIGH")
@PrimaryKeyJoinColumn(name = "ID")
@NamedQueries({
		@NamedQuery(name = "selectMamor", query = "select mamor from MamorinTahghigh as mamor"),
		@NamedQuery(name = "selectUniqeMamor", query = "select mamor from MamorinTahghigh as mamor where mamor.id=:id"),
//		@NamedQuery(name = "selectJoinFetchMamor", query = "select mamor from MamorinTahghigh as mamor join fetch mamor.motaghazis"),
//		@NamedQuery(name = "selectJoin", query = "select mamor from MamorinTahghigh mamor join mamor.motaghazis m where m.firstname=:name")

})
public class MamorinTahghigh extends User {
	@Column(name = "CODE")
	private String code;
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "MAMOR_MOTA", joinColumns = { @JoinColumn(name = "MAMOR_ID", referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(name = "MOTA_ID", referencedColumnName = "ID") })
//	private Set<MoshakhasateMotaghazi> motaghazis;
	@Column(name = "My_DATE")
	private Date date;
	@Transient
	private String strDate;
	@Transient
	private boolean state;

	public MamorinTahghigh() {

	}

	public MamorinTahghigh(String firstname) {
		super.setFirstname(firstname);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
//
//	public Set<MoshakhasateMotaghazi> getMotaghazis() {
//		if (motaghazis == null) {
//			motaghazis = new HashSet<>();
//		}
//		return motaghazis;
//	}
//
//	public void setMotaghazis(Set<MoshakhasateMotaghazi> motaghazis) {
//		this.motaghazis = motaghazis;
//	}

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

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

}
