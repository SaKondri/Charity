package com.friends.charity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.friends.charity.model.BaseEntity;

@Entity
@Table(name = "NIAZ_MOTAGHAZI")
public class NiazMotaghazi extends BaseEntity {
	@Column(name = "HOME")
	private boolean home;
	@Column(name = "BIMARI")
	private boolean bimari;
	@Column(name = "JAHAZIYE")
	private boolean jahaziye;
	@Column(name = "KASRE_KHARJ")
	private boolean kasreKharj;
	@Column(name = "VAAM")
	private boolean vaam;
	@Column(name = "ETC")
	private boolean etc;

	public boolean isHome() {
		return home;
	}

	public void setHome(boolean home) {
		this.home = home;
	}

	public boolean isBimari() {
		return bimari;
	}

	public void setBimari(boolean bimari) {
		this.bimari = bimari;
	}

	public boolean isJahaziye() {
		return jahaziye;
	}

	public void setJahaziye(boolean jahaziye) {
		this.jahaziye = jahaziye;
	}

	public boolean isKasreKharj() {
		return kasreKharj;
	}

	public void setKasreKharj(boolean kasreKharj) {
		this.kasreKharj = kasreKharj;
	}

	public boolean isVaam() {
		return vaam;
	}

	public void setVaam(boolean vaam) {
		this.vaam = vaam;
	}

	public boolean isEtc() {
		return etc;
	}

	public void setEtc(boolean etc) {
		this.etc = etc;
	}

}
