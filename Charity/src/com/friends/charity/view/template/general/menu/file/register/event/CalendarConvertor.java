package com.friends.charity.view.template.general.menu.file.register.event;

import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sahandrc.calendar.PersianCalendar;
import com.sahandrc.calendar.PersianDateParser;

@FacesConverter(value = "CalendarConvertor")
public class CalendarConvertor implements Converter {
	private Date rsDate;
	private String str;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		setStr(value);
		String date[] = rond(value);
		PersianCalendar persianCalendar;
		persianCalendar = new PersianDateParser(date[0] + "/" + date[1] + "/"
				+ date[2]).getPersianDate();
		setRsDate(persianCalendar.getTime());
		return getRsDate();

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return getStr();
	}

	public String[] rond(String value) {
		String result[] = new String[3];
		String str[] = value.split("/");
		result[0] = str[2];
		result[1] = str[1];
		result[2] = str[0];
		return result;

	}

	public Date getRsDate() {
		return rsDate;
	}

	public void setRsDate(Date rsDate) {
		this.rsDate = rsDate;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}
