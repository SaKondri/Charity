package com.friends.charity.business.logic;

import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;

import com.friends.charity.model.MaskanType;

@FacesConverter(value = "securityRoleConverter")
public class SecurityRoleConverter extends EnumConverter {

	public SecurityRoleConverter() {
		super(MaskanType.class);
	}

}