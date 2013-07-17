package com.friends.charity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "USER_IMAGE")
@NamedQueries({ @NamedQuery(name = "userImages", query = "select ui from UserImage ui where ui.id=:id") })
public class UserImage extends BaseEntity {
	@Column(name = "IMAGE")
	@Lob
	private byte[] image;
	@Column(name = "PIC_NAME")
	private String picName;
	@Column(name = "HAS_PIC")
	private boolean hasPic;
	@Transient
	private int i;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public boolean isHasPic() {
		return hasPic;
	}

	public void setHasPic(boolean hasPic) {
		this.hasPic = hasPic;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}
