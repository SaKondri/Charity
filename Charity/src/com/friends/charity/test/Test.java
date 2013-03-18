package com.friends.charity.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		String str;
		DateFormat format = new SimpleDateFormat("yyyy/dd/mm");
		str=format.format(c.getTime());
		System.out.println(str);

	}
}
