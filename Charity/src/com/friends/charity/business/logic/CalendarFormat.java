package com.friends.charity.business.logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarFormat {
	public static Calendar getGerigorian(Date date) {
		DateFormat format = new SimpleDateFormat("yyyy/mm/dd");
		format.format(date);
		Calendar calendar;
		calendar = (format.getCalendar());
		return calendar;
	}

	public static String getStrDate(Calendar calendar) {
		String str;
		DateFormat format = new SimpleDateFormat("yyyy/mm/dd");
		str = format.format(calendar.getTime());
		return str;
	}

}
