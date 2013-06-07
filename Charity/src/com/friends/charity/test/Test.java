package com.friends.charity.test;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.weld.context.beanstore.HashMapBeanStore;
import org.primefaces.model.StreamedContent;

import sun.launcher.resources.launcher;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.dao.GeneralDao;
import com.friends.charity.model.Login;
import com.friends.charity.model.UsernamePassword;
import com.friends.charity.model.admin.about.Qustion;
import com.friends.charity.model.admin.about.Response;
import com.friends.charity.model.admin.about.Tariekhche;
import com.friends.charity.view.template.admin.menu.addpicture.model.AddPictureModel;

public class Test {

	public static void main(String args[]) {
		GeneralService generalService = new GeneralService();
		GeneralDao dao = new GeneralDao();
//		Qustion qustion = new Qustion();
//		try {
//			qustion.setTitle("test");
//			
//			try {
//				for (int i = 0; i <9; i++) {
//					generalService.save(qustion);
//				}
//				
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Qustion qustion = new Qustion();
//		Response response = new Response();
//		response.setResponseForQustion("okey");
//		try {
//			qustion.setTitle("test");
//		} catch (UnsupportedEncodingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		qustion.setResponse(response);
//		try {
//			for (int i = 0; i < 500; i++) {
//				generalService.save(qustion);
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//	List<Qustion> qustions;
//	try {
//		qustions = dao.selectListValue( 2*10-10, 10);
//		for (Qustion qustion : qustions) {
//			System.out.println(qustion.getId() +"  ====>res   "+ qustion.getResponse().getResponseForQustion());
//		}
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
		
		//qustionList.setQustions(getGeneralService().selectListValue((btnValue*10)-10, 10));
		int size = 82;
		List<Qustion> qustions = new ArrayList<>();
		Integer first = 9*10;
		Integer mod = size%10;
		if(size >= first){
			qustions =generalService.selectListValue(first -10, 10);
		}else if (size < first) {
			first=first-10;
			
			qustions=generalService.selectListValue(first, mod);
		}
		for (Qustion qustion : qustions) {
			System.out.println(qustion.getId());
		}
	}
}