package com.friends.charity.test;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.admin.about.Qustion;


public class Test  {
	public static void main(String[] args) throws UnsupportedEncodingException {
		Qustion qustion = new Qustion();
		GeneralService generalService = new GeneralService();
		qustion.setTitle("test");
		try {
			for (int i = 0; i <500; i++) {
				generalService.save(qustion);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}