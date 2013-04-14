package com.friends.charity.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;
import org.primefaces.model.StreamedContent;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.dao.GeneralDao;
import com.friends.charity.model.Login;
import com.friends.charity.model.UsernamePassword;
import com.friends.charity.view.template.admin.menu.addpicture.model.AddPictureModel;

public class Test {

	public static void main(String[] args) {
		AddPictureModel model = new AddPictureModel();
		List<AddPictureModel> list = new ArrayList<>();
		model.setName("saeed");
		model.setDescription("amini");
		list.add(model);
		AddPictureModel model1 = new AddPictureModel();
		model.setName("sina");
		model.setDescription("maliki");
		list.add(model1);
		for (AddPictureModel addPictureModel : list) {
			try {
				if(addPictureModel.getName().equals("saeed")){
					System.out.println(addPictureModel.getDescription());
			}
				} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
	
}
}