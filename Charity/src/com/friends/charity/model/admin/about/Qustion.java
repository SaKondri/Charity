package com.friends.charity.model.admin.about;

import java.io.UnsupportedEncodingException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.friends.charity.business.logic.Utils;
import com.friends.charity.model.BaseEntity;

@Entity
@Table(name = "QUSTION")
public class Qustion extends BaseEntity {
	@Column(name = "TITLE")
	private String title;
	@Column(name = "DESCRIPTION", columnDefinition = "text")
	private String description;
	@Column(name = "CODE_PEYGIRY")
	private long codePeygiry;
	@Column(name = "FIRST_NAME")
	private String fName;
	@Column(name = "LAST_NAME")
	private String lName;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) throws UnsupportedEncodingException {
		this.fName = Utils.exportToUTF_8(fName);
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) throws UnsupportedEncodingException {
		this.lName = Utils.exportToUTF_8(lName);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) throws UnsupportedEncodingException {
		
		this.title =Utils.exportToUTF_8(title);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) throws UnsupportedEncodingException {
		this.description = Utils.exportToUTF_8(description);
	}

	public long getCodePeygiry() {
		return codePeygiry;
	}

	public void setCodePeygiry(long codePeygiry) {
		this.codePeygiry = codePeygiry;
	}

}
