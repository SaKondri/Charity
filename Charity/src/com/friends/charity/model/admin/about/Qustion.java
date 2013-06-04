package com.friends.charity.model.admin.about;

import java.io.UnsupportedEncodingException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.servlet.http.HttpServletResponse;

import com.friends.charity.business.logic.Utils;
import com.friends.charity.model.BaseEntity;

@Entity
@Table(name = "QUSTION")
@NamedQueries({
	@NamedQuery (name ="allQustions" , query = "select q from Qustion q")
	
})
public class Qustion extends BaseEntity{
	@Column(name = "TITLE" , columnDefinition = "text")
	private String title;
	@Column(name = "DESCRIPTION", columnDefinition = "text")
	private String description;
	@Column(name = "CODE_PEYGIRY")
	private long codePeygiry;
	@Column(name = "FIRST_NAME")
	private String fName;
	@Column(name = "LAST_NAME")
	private String lName;
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Response response;
	
	public Response getResponse() {
		if(response == null){
			response = new Response();
		}
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
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
