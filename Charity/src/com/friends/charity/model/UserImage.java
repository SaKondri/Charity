package com.friends.charity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "USER_IMAGE")
public class UserImage extends BaseEntity {
	@Column(name = "IMAGE")
	@Lob
	private byte[] image;
	@Column(name = "PIC_NAME")
	private String picName;
	@Column(name = "HAS_PIC")
	private boolean hasPic;

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

}