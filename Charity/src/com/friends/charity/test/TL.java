package com.friends.charity.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TL implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
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
