package com.friends.charity.model.admin.about;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.friends.charity.model.BaseEntity;

@Entity
@Table(name = "TARIEKHCHE")
public class Tariekhche extends BaseEntity {
	@Size(max = 2000000000)
	@Column(name = "TITLE")
	private String title;
	@Size(max = 2000000000)
	@Column(name = "DESCRIPTION")
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
