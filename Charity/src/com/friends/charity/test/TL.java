package com.friends.charity.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.friends.charity.dao.GeneralDao;
import com.friends.charity.model.Login;

@WebListener
public class TL implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		GeneralDao loginService = new GeneralDao();
		List<Login> l = new ArrayList<>();
		l = loginService.selectList("u", null);
		if (l != null) {
			for (Login login : l) {
				System.out.println(login.getUsernamePassword().getUsername());
			}
		} else {
			System.out.println("sddddddddddddddddddddddddddddddddddddddd");
		}
//		GeneralDao dao = new GeneralDao();
//		MoshakhasateMotaghazi user = new MoshakhasateMotaghazi();
//		user.setFirstname("fath");
//		user.setBirthday(Calendar.getInstance());
//		Dokhtar dokhtar = new Dokhtar();
//		Pesar pesar = new Pesar();
//		dokhtar.setFirstname("popo");
//		pesar.setFirstname("sdfjkn");
//		user.setMaskanType(MaskanType.ESTIJARI);
//		user.setCodeMelli("0012624691");
//		List<Farzandan> farzandans = new ArrayList<>();
//		farzandans.add(pesar);
//		farzandans.add(dokhtar);
//
//		user.setFarzandans(farzandans);
//		BargehTahghighateMojadad mojadad = new BargehTahghighateMojadad();
//		mojadad.setMoshakhasateMotaghazi(user);
//		try {
//			dao.save(mojadad);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
