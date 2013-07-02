package com.friends.charity.model.admin.about;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.friends.charity.model.BaseEntity;
@Entity
@Table(name = "QUSETION_TEMP")
@NamedQueries({
	@NamedQuery (name = "allTempQustion" , query = "select qt from QustionTemp qt"),
	@NamedQuery(name = "sizeTempQustionTable" , query = "select count(qt) from QustionTemp qt")
})

public class QustionTemp extends BaseEntity{
	@Column(name = "TITLE", columnDefinition = "text")
	private String title;
	@Column(name = "DESCRIPTION", columnDefinition = "text")
	private String description;
	@Column(name = "CODE_PEYGIRY")
	private long codePeygiry;
	@Column(name = "FIRST_NAME")
	private String fName;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Response response;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getCodePeygiry() {
		return codePeygiry;
	}
	public void setCodePeygiry(long codePeygiry) {
		this.codePeygiry = codePeygiry;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public Response getResponse() {
		if(response == null){
			response = new Response();
		}
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	
	
}
