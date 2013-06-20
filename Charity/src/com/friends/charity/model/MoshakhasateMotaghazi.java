package com.friends.charity.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.friends.charity.business.logic.CalendarFormat;
import com.friends.charity.model.farzand.Farzandan;

@Entity
@Table(name = "MOSHAKHASATE_MOTAGHAZI")
@PrimaryKeyJoinColumn(name = "ID")
@NamedQueries({ @NamedQuery(name = "selectUsers", query = "Select usr from MoshakhasateMotaghazi usr") })
public class MoshakhasateMotaghazi extends User {
	@Column(name = "HAMSAR_FIRST_NAME")
	private String hamsarFirstname;
	@Column(name = "HAMSAR_LAST_NAME")
	private String hamsarLastname;
	@Column(name = "HAMSAR_BIRTHDAY")
	@Temporal(TemporalType.DATE)
	private Calendar hamsarBirthday;
	@Column(name = "SHOGHL")
	private String shoghl;
	@Column(name = "DARAMAD")
	private String daramad;
	@Column(name = "MASKAN_TYPE")
	@Enumerated(EnumType.STRING)
	private MaskanType maskanType;
	@Column(name = "EJAREH_MAHIYANEH")
	private String ejareMahiyaneh;
	@Column(name = "BIMEH")
	private String noeBimehVaSabegheh;
	@Column(name = "HOME_ADDRESS")
	private String homeAddress;
	@Column(name = "JOB_ADDRESS")
	private String jobAddress;
	@Column(name = "CODE_MELLI")
	private String codeMelli;
	@Column(name = "CODE_POSTI")
	private String codePosti;
	@Column(name = "HOME_NUMBER")
	private String homeNumber;
	@Column(name = "JOB_NUMBER")
	private String jobNumber;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "sarparast_ID", referencedColumnName = "ID")
	private List<Farzandan> farzandans;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private UserImage userImage;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private TarikhSabteNameKarbar tarikhSabteNameKarbar;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private UserActive userActive;
	@Column(name = "MY_SELF_DATE")
	private Date mySelfDate;
	@Column(name = "MY_WIFE_DATE")
	private Date myWifeDate;
	@Transient
	private String mySelfStrDate;
	@Transient
	private String myWifeStrDate;

	public String getHamsarFirstname() {
		return hamsarFirstname;
	}

	public void setHamsarFirstname(String hamsarFirstname) {
		this.hamsarFirstname = hamsarFirstname;
	}

	public String getHamsarLastname() {
		return hamsarLastname;
	}

	public void setHamsarLastname(String hamsarLastname) {
		this.hamsarLastname = hamsarLastname;
	}

	public Calendar getHamsarBirthday() {
		return hamsarBirthday;
	}

	public void setHamsarBirthday(Calendar hamsarBirthday) {
		this.hamsarBirthday = hamsarBirthday;
	}

	public String getShoghl() {
		return shoghl;
	}

	public void setShoghl(String shoghl) {
		this.shoghl = shoghl;
	}

	public String getDaramad() {
		return daramad;
	}

	public void setDaramad(String daramad) {
		this.daramad = daramad;
	}

	public MaskanType getMaskanType() {
		return maskanType;
	}

	public void setMaskanType(MaskanType maskanType) {
		this.maskanType = maskanType;
	}

	public String getEjareMahiyaneh() {
		return ejareMahiyaneh;
	}

	public void setEjareMahiyaneh(String ejareMahiyaneh) {
		this.ejareMahiyaneh = ejareMahiyaneh;
	}

	public String getNoeBimehVaSabegheh() {
		return noeBimehVaSabegheh;
	}

	public void setNoeBimehVaSabegheh(String noeBimehVaSabegheh) {
		this.noeBimehVaSabegheh = noeBimehVaSabegheh;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getJobAddress() {
		return jobAddress;
	}

	public void setJobAddress(String jobAddress) {
		this.jobAddress = jobAddress;
	}

	public String getCodeMelli() {
		return codeMelli;
	}

	public void setCodeMelli(String codeMelli) {
		this.codeMelli = codeMelli;
	}

	public String getCodePosti() {
		return codePosti;
	}

	public void setCodePosti(String codePosti) {
		this.codePosti = codePosti;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public List<Farzandan> getFarzandans() {
		if (farzandans == null) {
			farzandans = new ArrayList<>();
		}
		return farzandans;
	}

	public void setFarzandans(List<Farzandan> farzandans) {
		this.farzandans = farzandans;
	}

	public Date getMySelfDate() {
		return mySelfDate;
	}

	public void setMySelfDate(Date mySelfDate) {
		this.mySelfDate = mySelfDate;
	}

	public Date getMyWifeDate() {
		return myWifeDate;
	}

	public void setMyWifeDate(Date myWifeDate) {
		this.myWifeDate = myWifeDate;
	}

	public String getMySelfStrDate() {
		mySelfStrDate = CalendarFormat.getStrForDT(getMySelfDate());
		return mySelfStrDate;
	}

	public void setMySelfStrDate(String mySelfStrDate) {
		this.mySelfStrDate = mySelfStrDate;
	}

	public String getMyWifeStrDate() {
		if (getMyWifeDate() != null) {
			myWifeStrDate = CalendarFormat.getStrForDT(getMyWifeDate());
		}
		return myWifeStrDate;
	}

	public void setMyWifeStrDate(String myWifeStrDate) {
		this.myWifeStrDate = myWifeStrDate;
	}

	public UserImage getUserImage() {
		if (userImage == null) {
			userImage = new UserImage();
		}
		return userImage;
	}

	public void setUserImage(UserImage userImage) {
		this.userImage = userImage;
	}

	public TarikhSabteNameKarbar getTarikhSabteNameKarbar() {
		if (tarikhSabteNameKarbar == null) {
			tarikhSabteNameKarbar = new TarikhSabteNameKarbar();
		}
		return tarikhSabteNameKarbar;
	}

	public void setTarikhSabteNameKarbar(
			TarikhSabteNameKarbar tarikhSabteNameKarbar) {
		this.tarikhSabteNameKarbar = tarikhSabteNameKarbar;
	}

	public UserActive getUserActive() {
		if (userActive == null) {
			userActive = new UserActive();
		}
		return userActive;
	}

	public void setUserActive(UserActive userActive) {
		this.userActive = userActive;
	}

}