package com.friends.charity.business.logic;

import java.io.UnsupportedEncodingException;

public  class Utils {
	public static String exportToUTF_8(String str) throws UnsupportedEncodingException {
		String s = new String(str.getBytes("ISO-8859-1"), "UTF-8");
		return s;
	}
}
