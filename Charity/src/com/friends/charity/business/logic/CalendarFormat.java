package com.friends.charity.business.logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sahandrc.calendar.PersianCalendar;

public class CalendarFormat {
	private static String month[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun",
			"Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

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

	public static String getStrForDT(Date date) {
		Calendar calendar = Calendar.getInstance();
		PersianCalendar persianCalendar = new PersianCalendar();
		int year;
		int month;
		int day;
		String str[];
		calendar.setTime(date);
		str = calendar.getTime().toString().split(" ");
		year = Integer.parseInt(str[5]);
		month = getMonths(str[1]);
		day = Integer.parseInt(str[2]);
		persianCalendar.set(year, month, day);
		return persianCalendar.getPersianShortDate();
	}

	private static int getMonths(String mon) {
		for (int i = 0; i < month.length; i++) {
			if (mon.equals(month[i])) {
				return i;
			}
		}
		return 0;
	}

}