package com.friends.charity.model.admin.about;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.friends.charity.model.BaseEntity;
@NamedQueries({
	
			
			@NamedQuery(name = "showTarikhche" , query = "select t from Tariekhche t ")})
@Entity													  
@Table(name = "TARIEKHCHE")
public class Tariekhche extends BaseEntity {
	
	@Column(name = "TITLE" )
	private String title;
	
	
	
	
	@Column(name = "DESCRIPTION" , columnDefinition = "text")
	private String description;

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

}
