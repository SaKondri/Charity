package com.friends.charity.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.MamorinTahghigh;
import com.friends.charity.model.MoshakhasateMotaghazi;

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