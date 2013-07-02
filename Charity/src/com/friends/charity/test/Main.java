package com.friends.charity.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.dao.GeneralDao;
import com.friends.charity.model.admin.about.Qustion;

public class Main {  
	public static void main(String[] args) throws UnsupportedEncodingException {
		Qustion qustion = new Qustion();
		GeneralService generalService = new GeneralService();
		List<Qustion> qustions = new ArrayList<>();
		qustions =  generalService.selectList("qustionsNoReply", null);
		System.out.println(qustions.size());
		for (Qustion qustion2 : qustions) {
			System.out.println(qustion2.getTitle());
		}
			
	}
}
