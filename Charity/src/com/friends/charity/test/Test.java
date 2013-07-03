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
import com.friends.charity.view.template.admin.menu.addpicture.model.AddPictureModel;


public class Test  {
	public static void main(String[] args) throws UnsupportedEncodingException {
		Qustion qustion = new Qustion();
		qustion.setTitle("test");
		GeneralService service = new GeneralService();
		for(int i= 0 ; i<100;i++){
		try {
			service.save(qustion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}
}