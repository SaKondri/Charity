package com.friends.charity.test;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import com.friends.charity.view.template.admin.menu.addpicture.model.SliderPic;


public class Test  {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		SliderPic  sliderPic = new SliderPic();
		List<SliderPic> list = new ArrayList<>();
		sliderPic.setName("saeed");
		sliderPic.setDiscreption("amini");
		list.add(sliderPic);
		sliderPic = new SliderPic();
		sliderPic.setName("sina");
		sliderPic.setDiscreption("maliki");
		list.add(sliderPic);
		for (SliderPic sliderPic2 : list) {
			if(sliderPic2.getName().equals("sina"))
				System.out.println(sliderPic2.getDiscreption());
		}

		}
}