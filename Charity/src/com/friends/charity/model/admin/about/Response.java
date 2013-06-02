package com.friends.charity.model.admin.about;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.friends.charity.model.BaseEntity;
@Entity
@Table(name = "RESPONSE")
public class Response extends BaseEntity{
	@Column(name = "RESPONSE_FOR_QUSTION" , columnDefinition = "text")
	private String responseForQustion;
	
	
	
	public String getResponseForQustion() {
		return responseForQustion;
	}
	public void setResponseForQustion(String responseForQustion) {
		this.responseForQustion = responseForQustion;
	}
}
