package com.friends.charity.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.dao.GeneralDao;
import com.friends.charity.model.Login;
import com.friends.charity.model.UsernamePassword;

public class Test {

	public static void main(String[] args) {
		Map<String, Object> params = new HashMap<>();
		params.put("username", "Ali");
		params.put("pass", "Alavi");
		if (params != null) {
			for (Entry<String, Object> e : params.entrySet()) {
				System.out.println((e.getKey() + "dssd" + e.getValue()));
			}
		}
	}
}
