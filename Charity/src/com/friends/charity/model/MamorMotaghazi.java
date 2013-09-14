package com.friends.charity.model;

import javax.persistence.Entity;

@Entity
public class MamorMotaghazi extends BaseEntity {
	private long mamorId;
	private long motaghaziId;

	public long getMamorId() {
		return mamorId;
	}

	public void setMamorId(long mamorId) {
		this.mamorId = mamorId;
	}

	public long getMotaghaziId() {
		return motaghaziId;
	}

	public void setMotaghaziId(long motaghaziId) {
		this.motaghaziId = motaghaziId;
	}

}
