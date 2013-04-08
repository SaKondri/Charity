package com.friends.charity.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.dao.GeneralDao;
import com.friends.charity.model.Login;
import com.friends.charity.model.User;
import com.friends.charity.model.UsernamePassword;

@WebListener
public class TL implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		// /////////////////////1/////////////////////////////
		// Login login = new Login();
		// UsernamePassword usernamePassword = new UsernamePassword();
		// usernamePassword.setUsername("Ali");
		// usernamePassword.setPassword("Alavi");
		// login.setUsernamePassword(usernamePassword);
		// try {
		// new GeneralService().save(login);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// //////////////////////2////////////////
//		GeneralDao dao = new GeneralDao();
//		List<Login> result = new ArrayList<>();
//		Map<String, Object> map = new HashMap<>();
//		map.put("username", "s");
//		map.put("password", "s");
//		try {
//			result = dao.selectList("selectUsernamePassword", map, null, null);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		for (Login login : result) {
//			System.out.println(login.getUsernamePassword().getUsername());
//		}
	}

}
