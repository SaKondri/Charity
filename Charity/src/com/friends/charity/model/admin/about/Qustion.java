package com.friends.charity.model.admin.about;

import java.io.UnsupportedEncodingException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.HashPartitioning;
import org.eclipse.persistence.annotations.Partitioned;

import com.friends.charity.business.logic.Utils;
import com.friends.charity.model.BaseEntity;

@Entity
@Table(name = "QUSTION")

@NamedQueries({
		@NamedQuery(name = "allQustions", query = "select q from Qustion q order by q.id"),
		@NamedQuery(name = "qustionTableSize", query = "select count(q) from Qustion q"),
		@NamedQuery(name = "selectById", query = "select q from Qustion q where q.id = :id"),
		@NamedQuery(name = "selectDontReplayQustion", query = "select count(q) from Qustion q where q.response is null"),
		@NamedQuery(name = "qustionsNoReply", query = "select q from Qustion q where q.response is null") })
public class Qustion extends BaseEntity {
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

	public Response getResponse() {
		if (response == null) {
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) throws UnsupportedEncodingException {

		this.title = Utils.exportToUTF_8(title);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description)
			throws UnsupportedEncodingException {
		this.description = Utils.exportToUTF_8(description);
	}

	public long getCodePeygiry() {
		return codePeygiry;
	}

	public void setCodePeygiry(long codePeygiry) {
		this.codePeygiry = codePeygiry;
	}

}
