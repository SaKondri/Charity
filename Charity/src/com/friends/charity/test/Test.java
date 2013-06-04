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

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.dao.GeneralDao;
import com.friends.charity.model.Login;
import com.friends.charity.model.UsernamePassword;
import com.friends.charity.model.admin.about.Qustion;
import com.friends.charity.model.admin.about.Response;
import com.friends.charity.model.admin.about.Tariekhche;
import com.friends.charity.view.template.admin.menu.addpicture.model.AddPictureModel;

public class Test {
	
	public static void main(String args[]){
		 
		List<String> unsortList = new ArrayList<String>();
 
		unsortList.add("CCC");
		unsortList.add("111");
		unsortList.add("AAA");
		unsortList.add("BBB");
		unsortList.add("ccc");
		unsortList.add("bbb");
		unsortList.add("aaa");
		unsortList.add("333");
		unsortList.add("222");
 
		//before sort
		System.out.println("ArrayList is unsort");
		for(String temp: unsortList){
			System.out.println(temp);
		}
 
		//sort the list
		Collections.sort(unsortList);
		Collections.sort(unsortList);
 
		//after sorted
		System.out.println("ArrayList is sorted");
		for(String temp: unsortList){
			System.out.println(temp);
		}
	}
}