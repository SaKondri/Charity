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
		List<String> list = new ArrayList<>();
		List<AddPictureModel> models = new ArrayList<>();
		AddPictureModel addPictureModel = new AddPictureModel();
		addPictureModel.setName("1");
		models.add(addPictureModel);
		addPictureModel.setName("2");
		models.add(addPictureModel);
		System.out.println(models);
	}
}