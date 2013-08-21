package com.friends.charity.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Past;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.dao.GeneralDao;
import com.friends.charity.model.BaseEntity;
import com.friends.charity.model.MamorinTahghigh;
import com.friends.charity.model.MoshakhasateMotaghazi;
import com.friends.charity.test.model.Employee;
import com.friends.charity.test.model.Meeting;
import com.sun.faces.vendor.GlassFishInjectionProvider;

public class Main {

	public static void main(String[] args) throws Exception {
		GeneralService service = new GeneralService();
		Map<String, Object> params = new HashMap<>();
		params.put("fn", "sina");
		List<MoshakhasateMotaghazi> list = new ArrayList<>();
		list = service.selectLazyList("Mamor_Join", params);
		for (MoshakhasateMotaghazi motaghazi : list) {
//			System.out.println(motaghazi.getFirstname());
			for (MamorinTahghigh tahghigh : motaghazi.getMamors()) {
				System.out.println(tahghigh.getFirstname());
			}
		}
		service.clear();
		List<MamorinTahghigh> list1 = new ArrayList<>();
		
		list1=service.selectList("selectMamor", null);
			System.err.println("ssss11111111");
		for (MamorinTahghigh mamorinTahghigh : list1){
			
			System.out.println(mamorinTahghigh.getFirstname());
		}
//		GeneralDao.getGeneralDao().close();
		// MamorinTahghigh mamorinTahghigh1=new MamorinTahghigh("sina");
		// MamorinTahghigh mamorinTahghigh2=new MamorinTahghigh("arash");
		//
		// MoshakhasateMotaghazi motaghazi1=new
		// MoshakhasateMotaghazi("elizabet");
		// MoshakhasateMotaghazi motaghazi2=new MoshakhasateMotaghazi("tom");
		//
		// mamorinTahghigh1.getMotaghazis().add(motaghazi1);
		// mamorinTahghigh1.getMotaghazis().add(motaghazi2);
		//
		// mamorinTahghigh2.getMotaghazis().add(motaghazi1);
		//
		// service.save(mamorinTahghigh1);
		// service.save(mamorinTahghigh2);
	}
}