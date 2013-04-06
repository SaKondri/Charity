package com.friends.charity.view.template.general.menu.file.register.event;

import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;

import com.friends.charity.model.MaskanType;

@FacesConverter(value = "securityRoleConverter")
public class SecurityRoleConverter extends EnumConverter {

	public SecurityRoleConverter() {
		super(MaskanType.class);
	}

}