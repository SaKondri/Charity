package com.friends.charity.business.logic;

import java.io.UnsupportedEncodingException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public  class Utils {
	public static String exportToUTF_8(String str) throws UnsupportedEncodingException {
		String s = new String(str.getBytes("ISO-8859-1"), "UTF-8");
		return s;
	}
	public static Object getSession(String sessionName){
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		Object result= request.getSession().getAttribute(sessionName);
		return result;
	}
	public static void setSession(String name , Object value){
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		request.getSession().setAttribute(name, value);
	}
}
