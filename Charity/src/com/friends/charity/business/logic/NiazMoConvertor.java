package com.friends.charity.business.logic;

import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;

import com.friends.charity.model.NiazMotaghazii;

@FacesConverter(value = "NizConv")
public class NiazMoConvertor extends EnumConverter {
	public NiazMoConvertor() {
		super(NiazMotaghazii.class);
	}

}
